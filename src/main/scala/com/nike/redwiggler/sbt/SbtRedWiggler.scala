package com.nike.redwiggler.sbt

import com.nike.redwiggler.core._
import com.nike.redwiggler.html.HtmlReportProcessor
import com.nike.redwiggler.swagger.SwaggerEndpointSpecificationProvider
import sbt.Keys._
import sbt._

object SbtRedWiggler extends sbt.AutoPlugin {

  object autoImport {
    val swaggerFile = settingKey[File]("swagger.yaml file")
    val dataDirectory = settingKey[File]("setting directory")

    val redwiggler = taskKey[File]("Runs RedWiggler")
  }

  import autoImport._

  override def projectSettings: Seq[Def.Setting[_]] = Seq(
    swaggerFile := new File(baseDirectory.value, "swagger.yaml"),
    dataDirectory := new File(target.value, "redwiggler-input"),
    target in redwiggler := new File(target.value, "redwiggler.html"),
    resolvers += "nike" at "https://dl.bintray.com/nike/maven",
    redwiggler := {
      val output = (target in redwiggler).value
      Redwiggler(
        callProvider = new GlobEndpointCallProvider(dataDirectory.value, ".*.json"),
        specificationProvider = SwaggerEndpointSpecificationProvider(swaggerFile.value),
        reportProcessor = HtmlReportProcessor(output)
      )
      output
    }
  )

  def redwigglerDependency(name : String): ModuleID = "com.nike.redwiggler" %% s"redwiggler-$name" % BuildInfo.redwigglerVersion
}

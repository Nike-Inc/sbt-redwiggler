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

  val redwigglerRestAssured = "com.nike.redwiggler" %% "redwiggler-restassured" % BuildInfo.redwigglerVersion

  import autoImport._

  override def projectSettings: Seq[Def.Setting[_]] = Seq(
    swaggerFile := new File(baseDirectory.value, "swagger.yaml"),
    dataDirectory := new File(target.value, "redwiggler-input"),
    target in redwiggler := new File(target.value, "redwiggler.html"),
    redwiggler <<= (target in redwiggler, dataDirectory, swaggerFile) map { (output, dataDir, swagger) =>
      Redwiggler(
        callProvider = new GlobEndpointCallProvider(dataDir, ".*.json"),
        specificationProvider = SwaggerEndpointSpecificationProvider(swagger),
        reportProcessor = HtmlReportProcessor(output)
      )
      output
    }
  )
}

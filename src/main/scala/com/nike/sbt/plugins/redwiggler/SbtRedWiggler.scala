package com.nike.sbt.plugins.redwiggler

import sbt._
import Keys._
import com.nike.redwiggler.common.{ResultValidator, Configuration => RedWigglerConfiguration}

object SbtRedWiggler extends sbt.AutoPlugin {

  object autoImport {
    val blueprintFile = settingKey[File]("blueprint API.md file")
    val swaggerFile = settingKey[File]("swagger.yaml file")
    val dataDirectory = settingKey[File]("setting directory")

    val redwiggler = taskKey[File]("Runs RedWiggler")
  }

  val redwigglerRestAssured = "com.nike.redwiggler" % "redwiggler-restassured" % BuildInfo.redwigglerVersion

  import autoImport._

  override def projectSettings: Seq[Def.Setting[_]] = Seq(
    blueprintFile := new File(baseDirectory.value, "API.md"),
    swaggerFile := new File(baseDirectory.value, "swagger.yaml"),
    dataDirectory := new File(target.value, "redwiggler-input"),
    target in redwiggler := new File(target.value, "redwiggler.html"),
    redwiggler <<= (target in redwiggler, dataDirectory, blueprintFile, swaggerFile) map { (output, dataDir, mdFile, swagger) =>
      ResultValidator.validateResults(new RedWigglerConfiguration {
          val getMarkdownFile = mdFile
          val getSwaggerFile = swagger
          val getDataDirectory = dataDir
          val getOutput = output
      })
      output
    }
  )
}

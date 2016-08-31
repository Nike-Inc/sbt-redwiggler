package com.nike.sbt.plugins.redwiggler

import sbt._
import Keys._
import com.nike.retail.redwiggler.RedWiggler

object SbtRedWiggler extends sbt.AutoPlugin {

  object autoImport {
    val blueprintFile = settingKey[File]("blueprint API.md file")
    val dataDirectory = settingKey[File]("setting directory")

    val redwiggler = taskKey[File]("Runs RedWiggler")
  }

  import autoImport._

  override def projectSettings: Seq[Def.Setting[_]] = Seq(
    blueprintFile := new File(baseDirectory.value, "API.md"),
    dataDirectory := new File(target.value, "redwiggler-input"),
    target in redwiggler := new File((target in Compile).value, "redwiggler.html"),
    redwiggler <<= (target in redwiggler, dataDirectory, blueprintFile) map { (output, dataDir, mdFile) =>
      RedWiggler.validateResultsAgainstMarkdown(mdFile, dataDir, output)
      output
    }
  )
}

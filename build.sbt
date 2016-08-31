sbtPlugin := true

organization := "com.nike.sbt.plugins"

name := "sbt-redwiggler"

version := "0.1-SNAPSHOT"

scalacOptions ++= Seq("-feature", "-deprecation")

libraryDependencies ++= Seq(
  "com.nike.retail" % "redwiggler" % "1.4.8"
)

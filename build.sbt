sbtPlugin := true

enablePlugins(BuildInfoPlugin)

organization := "com.nike.sbt.plugins"

name := "sbt-redwiggler"

version := "0.1-SNAPSHOT"

scalacOptions ++= Seq("-feature", "-deprecation")

resolvers += Resolver.mavenLocal

val redwigglerVersion = "0.4"

libraryDependencies ++= Seq(
  "com.nike.redwiggler" % "redwiggler-common" % redwigglerVersion
)

buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion, "redwigglerVersion" -> redwigglerVersion)

buildInfoPackage := "com.nike.sbt.plugins.redwiggler"

sbtPlugin := true

enablePlugins(GitVersioning, BuildInfoPlugin)

organization := "com.nike.sbt.plugins"

name := "sbt-redwiggler"

git.baseVersion := "0.2"

git.useGitDescribe := true

scalacOptions ++= Seq("-feature", "-deprecation")

resolvers += Resolver.mavenLocal

val redwigglerVersion = "0.4"

libraryDependencies ++= Seq(
  "com.nike.redwiggler" % "redwiggler-common" % redwigglerVersion
)

buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion, "redwigglerVersion" -> redwigglerVersion)

buildInfoPackage := "com.nike.sbt.plugins.redwiggler"

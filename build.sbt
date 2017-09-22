sbtPlugin := true

enablePlugins(BuildInfoPlugin)

resolvers += Resolver.jcenterRepo

organization := "com.nike.redwiggler.sbt"

name := "sbt-redwiggler"

scalacOptions ++= Seq("-feature", "-deprecation")

resolvers += Resolver.mavenLocal

val redwigglerVersion = "0.5.1"

libraryDependencies ++= Seq(
  "com.nike.redwiggler" %% "redwiggler-reports-html" % redwigglerVersion,
  "com.nike.redwiggler" %% "redwiggler-swagger" % redwigglerVersion
)

buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion, "redwigglerVersion" -> redwigglerVersion)

buildInfoPackage := "com.nike.redwiggler.sbt"

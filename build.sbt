sbtPlugin := true

enablePlugins(BuildInfoPlugin)

resolvers += Resolver.jcenterRepo

organization := "com.nike.redwiggler.sbt"

name := "sbt-redwiggler"

crossSbtVersions := Seq("0.13.16", "1.1.6")

scalacOptions ++= Seq("-feature", "-deprecation")

resolvers += Resolver.mavenLocal

val redwigglerVersion = "0.5.6"

libraryDependencies ++= Seq(
  "com.nike.redwiggler" %% "redwiggler-reports-html" % redwigglerVersion,
  "com.nike.redwiggler" %% "redwiggler-swagger" % redwigglerVersion
)

buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion, "redwigglerVersion" -> redwigglerVersion)

buildInfoPackage := "com.nike.redwiggler.sbt"

ScriptedPlugin.scriptedSettings
scriptedLaunchOpts ++= Seq(
  "-Xmx1024M",
  "-Dplugin.version=" + version.value
)

scriptedLaunchOpts := { scriptedLaunchOpts.value ++
  Seq("-Xmx1024M", "-Dplugin.version=" + version.value)
}
scriptedBufferLog := false

coverageMinimum in ThisBuild := 95
coverageFailOnMinimum in ThisBuild := true
//https://stackoverflow.com/questions/24269214/why-does-the-scala-compiler-error-with-synthetic-tree-contains-nonsynthetic-tre
coverageHighlighting := false

licenses in ThisBuild := Seq(
  "BSD" -> new java.net.URL("https://opensource.org/licenses/BSD-3-Clause")
)
bintrayOrganization in ThisBuild := Some("nike")

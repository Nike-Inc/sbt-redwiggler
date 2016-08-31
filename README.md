# Usage

To add the sbt plugin to your project add the sbt plugin dependency in `project/plugins.sbt`:

```scala
addSbtPlugin("com.nike.sbt.plugins" %% "sbt-redwiggler" % "0.1-SNAPSHOT")
```

And enable the plugin on projects using:

```scala
someProject.enablePlugins(SbtRedWiggler)
```

If you only have a single project and are using a `build.sbt` file, create a root project and enable the local dynamodb plugin like this:

```scala
lazy val root = (project in file(".")).enablePlugins(SbtRedWiggler)
```


# sbt-redwiggler
[![Build Status](https://travis-ci.com/Nike-Inc/sbt-redwiggler.svg?token=PmECSWCH8LFEKNdzr64F&branch=master)](https://travis-ci.com/Nike-Inc/sbt-redwiggler)
[![Coverage Status](https://coveralls.io/repos/github/Nike-Inc/sbt-redwiggler/badge.svg)](https://coveralls.io/github/Nike-Inc/sbt-redwiggler)
[ ![Download](https://api.bintray.com/packages/nike/sbt-plugins/sbt-redwiggler/images/download.svg) ](https://bintray.com/nike/sbt-plugins/sbt-redwiggler/_latestVersion)

## Usage


To add the sbt plugin to your project add the sbt plugin dependency in `project/plugins.sbt`:

```scala
addSbtPlugin("com.nike.sbt.plugins" %% "sbt-redwiggler" % "0.1-SNAPSHOT")
```

And enable the plugin on projects using:

```scala
someProject.enablePlugins(SbtRedWiggler)
```

If you only have a single project and are using a `build.sbt` file, create a root project and enable the redwiggler plugin like this:

```scala
lazy val root = (project in file(".")).enablePlugins(SbtRedWiggler)
```


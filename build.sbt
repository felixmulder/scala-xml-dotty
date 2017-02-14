lazy val xml = project.in(file(".")).
  settings(
    // Dotty compilation
    scalaVersion := "0.1.1-20170212-8bdc91f-NIGHTLY",
    scalaOrganization := "ch.epfl.lamp",
    scalaBinaryVersion := "2.11",
    ivyScala ~= (_ map (_ copy (overrideScalaVersion = false))),
    libraryDependencies += "ch.epfl.lamp" % "dotty_2.11" % scalaVersion.value % "scala-tool",
    scalaCompilerBridgeSource := ("ch.epfl.lamp" % "dotty-sbt-bridge" % scalaVersion.value % "component").sources(),

    name := "scala-xml-dotty",
    version := "1.0.6-SNAPSHOT",
    //scalacOptions in Test  += "-Xxml:coalescing",
    scalacOptions ++= "-deprecation:false -feature -rewrite -language:Scala2".split("\\s+").to[Seq]
  ).
  settings(
    libraryDependencies ++= Seq(
      "com.novocode" % "junit-interface" % "0.10" % "test",
      "junit" % "junit" % "4.11" % "test"
    ),
    // You cannot disable JVM test forking when working on scala modules
    // that are distributed with the compiler because of an SBT
    // classloader leaking issue (scala/scala-xml#20 and #112).
    fork in Test := true
  )

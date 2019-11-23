import sbt._

object Dependencies {
  lazy val dependencies: Seq[ModuleID] =
    Seq(
      scalatest/*, logging, apacheCommons,
      cats, monocle,
      lombok*/ // To prevent weird issue: java.lang.ClassNotFoundException: com.sun.tools.javac.code.TypeTags
    ).flatten

  lazy val scalatest: Seq[ModuleID] = Seq(
    "org.scalatest" %% "scalatest" % "3.2.0-M1" % "test, it"
  )

  lazy val logging: Seq[ModuleID] = Seq(
    "org.slf4j" % "log4j-over-slf4j" % "1.7.28",
    "ch.qos.logback" % "logback-classic" % "1.2.3"
  )

  lazy val apacheCommons: Seq[ModuleID] = Seq(
    "org.apache.commons" % "commons-lang3" % "3.9"
  )

  lazy val cats: Seq[ModuleID] = {
    val version = "1.6.1"

    Seq(
      "org.typelevel" %% "cats-core"
    ).map(_ % version) ++ Seq(
      "org.typelevel" %% "cats-effect" % "1.4.0"
    ) ++ Seq(
      "org.typelevel" %% "cats-laws",
      "org.typelevel" %% "cats-testkit"
    ).map(_ % version % "test, it")
  }
  
  lazy val monocle: Seq[ModuleID] = {
    val version = "1.6.0"

    Seq(
      "com.github.julien-truffaut" %% "monocle-core",
      "com.github.julien-truffaut" %% "monocle-macro",
      "com.github.julien-truffaut" %% "monocle-generic"
    ).map(_ % version) ++ Seq(
      "com.github.julien-truffaut" %% "monocle-law"
    ).map(_ % version % "test, it")
  }

  lazy val lombok: Seq[ModuleID] = Seq(
    "org.projectlombok" % "lombok" % "1.18.8" % "provided"
  )
}
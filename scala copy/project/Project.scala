import sbt.Keys._
import sbt.{Project => SbtProject, _}
import Dependencies._

object Project {
  def apply(base: File): SbtProject =
    apply(base.getName, base)

  def apply(id: String, base: File): SbtProject =
    SbtProject(id, base)
      .settings(
        ThisBuild / turbo := true,
        scalaVersion := BuildProperties("scala.version"),
        sbtVersion := BuildProperties("sbt.version"),
        version := "0.1.0-SNAPSHOT",
        organization := "com.backwards",
        name := id,
        autoStartServer := false,
        addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.10.3"),
        libraryDependencies ++= dependencies,
        excludeDependencies ++= Seq("org.slf4j" % "slf4j-log4j12"),
        fork := true,
        scalacOptions ++= Seq("-Ypartial-unification")
      )
}
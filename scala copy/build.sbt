import sbt.{Project => _, _}

lazy val root = Project("scala-exercism-backwards", file("."))
  .settings(description := "Scala Exercism by Backwards")
  .aggregate(
    `hello-world`,
    `robot-name`,
    `matching-brackets`,
    `two-fer`,
    `house`,
    `food-chain`
  )

lazy val `hello-world` = Project(file("hello-world"))
lazy val `robot-name` = Project(file("robot-name"))
lazy val `matching-brackets` = Project(file("matching-brackets"))
lazy val `two-fer` = Project(file("two-fer"))
lazy val `beer-song` = Project(file("beer-song"))
lazy val `house` = Project(file("house"))
lazy val `food-chain` = Project(file("food-chain"))
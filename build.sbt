// Three projects:
//   lessons    — read and run these. Tests are already green.
//   exercises  — your work. Tests stay red until you replace ???.
//   solutions  — the same tests, against finished code. Look only after you try.
//
// `sbt test` runs lessons only, so a red exercise does not hide a green lesson.

ThisBuild / scalaVersion := "3.3.8"
ThisBuild / organization := "dev.finstream"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalacOptions ++= Seq("-deprecation", "-feature")

val munitVersion = "1.3.6"

lazy val commonSettings = Seq(
  libraryDependencies += "org.scalameta" %% "munit" % munitVersion % Test
)

lazy val lessons = (project in file("lessons"))
  .settings(
    commonSettings,
    name := "lessons"
  )

lazy val exercises = (project in file("exercises"))
  .settings(
    commonSettings,
    name := "exercises"
  )

lazy val solutions = (project in file("solutions"))
  .settings(
    commonSettings,
    name := "solutions",
    // Compile the exercise tests again, this time against solutions/src.
    Test / unmanagedSourceDirectories += (exercises / Test / scalaSource).value
  )

lazy val root = (project in file("."))
  .aggregate(lessons)
  .settings(
    name := "scala-onboarding",
    publish / skip := true
  )

// sbt "ex *Ex01*"  runs only the tests whose class name contains Ex01.
addCommandAlias("ex", "exercises/testOnly")

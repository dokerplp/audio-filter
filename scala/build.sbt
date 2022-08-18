import sbt.Keys.libraryDependencies

ThisBuild / version := "0.1.0"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "scala",
    libraryDependencies ++= Seq(
      "com.fasterxml.jackson.core" % "jackson-databind" % "2.13.3",
      "org.junit.jupiter" % "junit-jupiter-api" % "5.9.0" % Test
    )

  )

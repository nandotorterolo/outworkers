ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "outworkers",
    libraryDependencies ++= Seq(
      "com.outworkers" %% "phantom-dsl" % "2.12.6" % Compile  // << increase here
    )
  )
name := """[1;5Dchess-analytics-proto"""
organization := "com.ariel"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.4"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies += ws
libraryDependencies += "org.scala-lang.modules" %% "scala-async" % "0.9.7"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.ariel.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.ariel.binders._"

sbtavrohugger.SbtAvrohugger.avroSettings

libraryDependencies ++= Artifacts.dependencies

lazy val P = (project in file(".")).settings(
  organization := "no.penger",
  name := "export",
  description := "Exported models from Penger.no",
  scalaVersion := "2.12.3"
)
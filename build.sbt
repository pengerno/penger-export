import no.penger.sbt.CompilerFlags
sbtavrohugger.SbtAvrohugger.avroSettings

organization := "no.penger"

name := "export"

description := "Exported models from Penger.no"

scalaVersion := "2.12.2"

CompilerFlags.Level2.settings

enablePlugins(PengerConveniencePlugin)

buildInfoSettings("no.penger.export")
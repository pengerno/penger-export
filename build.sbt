import ReleaseTransformations._
sbtavrohugger.SbtAvrohugger.avroSettings

libraryDependencies ++= Artifacts.dependencies

releasePublishArtifactsAction := PgpKeys.publishSigned.value // Use publishSigned in publishArtifacts step
releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  publishArtifacts,
  setNextVersion,
  commitNextVersion,
  releaseStepCommand("sonatypeReleaseAll"),
  pushChanges
)

publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)

lazy val P = (project in file(".")).settings(
  organization := "no.penger",
  name := "export",
  description := "Exported models from Penger.no",
  scalaVersion := "2.12.3"
)
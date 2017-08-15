import sbt._

object Artifacts {

  val dependencies = Seq(
    "org.scalatest"       %% "scalatest"   % "3.0.1"  % "test",
    "org.scalacheck"      %% "scalacheck"  % "1.13.4" % "test",
    "com.sksamuel.avro4s" %% "avro4s-core" % "1.7.0"
  )

}

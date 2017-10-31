import sbt._

object Artifacts {

  val dependencies = Seq(
    "org.scalatest"       %% "scalatest"   % "3.0.4" % "test",
    "org.scalacheck"      %% "scalacheck"  % "1.13.5" % "test",
    "com.sksamuel.avro4s" %% "avro4s-core" % "1.8.0"
  )

}

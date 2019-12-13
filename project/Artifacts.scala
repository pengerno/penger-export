import sbt._

object Artifacts {

  val dependencies = Seq(
    "org.scalatest"       %% "scalatest"   % "3.0.8" % "test",
    "org.scalacheck"      %% "scalacheck"  % "1.14.0" % "test",
    "com.sksamuel.avro4s" %% "avro4s-core" % "3.0.0"
  )

}

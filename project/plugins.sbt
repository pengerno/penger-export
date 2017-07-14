resolvers ++= Seq("snapshot", "release") map {
  name => ("Finn-" + name) at ("http://mavenproxy.finntech.no/finntech-internal-" + name)
}

addSbtPlugin("no.penger" % "sbt-convenience" % "1.5.1")
addSbtPlugin("com.julianpeeters" % "sbt-avrohugger" % "0.16.0")
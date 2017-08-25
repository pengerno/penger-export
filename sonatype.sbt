// Your profile name of the sonatype account. The default is the same with the organization value
sonatypeProfileName := "no.penger"

// To sync with Maven central, you need to supply the following information:
publishMavenStyle := true

// License of your choice
licenses := Seq("MIT" -> url("https://mit-license.org/"))
homepage := Some(url("https://penger.no"))
scmInfo := Some(
  ScmInfo(
    url("https://github.com/pengerno/penger-export"),
    "scm:git@github.com:pengerno/penger-export.git"
  )
)
developers := List(
  Developer(id = "aspic",
            name = "Kjetil Mehl",
            email = "kjetil.mehl@schibsted.no",
            url = url("https://github.com/aspic")),
  Developer(id = "amund91",
            name = "Amund Murstad",
            email = "amund.murstad@schibsted.no",
            url = url("https://github.com/amund91"))
)

name := """ASE4156"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "com.socrata" % "soda-api-java" % "0.9.12",
  "junit" % "junit" % "4.4",
  "org.easytesting" % "fest-assert" % "1.4",
  "org.mockito" % "mockito-all" % "2.0.2-beta"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

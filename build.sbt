name := "CRUDApp"
version := "1.0"
scalaVersion := "2.12.6"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

routesGenerator := InjectedRoutesGenerator

resolvers ++= Seq(
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Typesafe Releases" at "http://repo.typesafe.com/typesafe/maven-releases/"
)

libraryDependencies ++= Seq(
  javaJdbc,
  evolutions,
  "com.typesafe.slick" %% "slick" % "3.2.0",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.2.0",
  "com.microsoft.sqlserver" % "mssql-jdbc" % "7.0.0.jre8",
  "com.typesafe.play" %% "play-slick" % "4.0.0-M4",
  "com.typesafe.play" %% "play-slick-evolutions" % "4.0.0-RC1"
)
name := "play-template"

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.4"

lazy val playTemplate = (project in file(".")).enablePlugins(PlayScala)

fork in Test := false


scalacOptions ++= Seq("-feature")

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws,
  "org.scalatestplus" % "play_2.10" % "1.1.0",
  "mysql" % "mysql-connector-java" % "5.1.18"
)

testOptions in Test := Nil
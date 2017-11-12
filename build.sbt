name := "yodb"
version := "0.1"

scalaSource in Test := baseDirectory.value / "test"
scalaSource in Compile := baseDirectory.value / "src"

scalaVersion := "2.12.4"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test"

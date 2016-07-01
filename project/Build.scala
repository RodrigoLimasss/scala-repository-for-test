import sbt.Keys._
import sbt._

object CustomBuild extends Build {

  val NamePrefix = "scala.repository.for.test"

  name := NamePrefix + "."

  lazy val wrapper = Project(
    id = "tests",
    base = file("tests")
  ).settings(Common.settings: _*)
    .settings(mainClass in Compile := Some("tests.Main"))
    .settings(libraryDependencies ++= Dependencies.streamingDependencies)

  fork in run := true
}
import sbt._

object Dependencies{

  val commonDependencies : Seq[ModuleID] = Seq(
    "org.scalatest" %% "scalatest" % "2.2.6"
  )

  val streamingDependencies : Seq[ModuleID] = commonDependencies
}
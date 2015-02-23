enablePlugins(ScalaJSPlugin)

name := "ScalaJsHelloWorld"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.5"

persistLauncher in Compile := true

persistLauncher in Test := false

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.8.0"

libraryDependencies += "com.greencatsoft" %%% "scalajs-angular" % "0.3"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.3" % "test"

testOptions in Test += Tests.Argument("-oD")
name := "bigtop-example"

version := "0.1"

seq(webSettings: _*)

jettyScanDirs := Nil

resolvers += "untyped" at "http://repo.untyped.com"

libraryDependencies ++= Seq(
  "bigtop" %% "bigtop-routes" % "0.2-SNAPSHOT",
  "net.liftweb" %% "lift-webkit" % "2.4-M4",
  "org.eclipse.jetty" % "jetty-webapp" % "7.3.0.v20110203" % "jetty",
  "org.scala-tools.testing" %% "specs" % "1.6.9" % "test"
)

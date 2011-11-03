name := "JqPlot liftmodule examples"
 
scalaVersion := "2.9.1"
 
seq(com.github.siasia.WebPlugin.webSettings :_*)

seq(bees.RunCloudPlugin.deploymentSettings :_*)

// If using JRebel uncomment.
jettyScanDirs := Nil

resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

resolvers += "liftmodules repository" at "http://repository-liftmodules.forge.cloudbees.com/release/"

libraryDependencies ++= {
  val liftVersion = "2.4-M4" 
  Seq(
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile->default",
    "net.liftmodules" %% "jqplot" %  (liftVersion+"-0.12.0"))
}

// Customize any further dependencies as desired
libraryDependencies ++= Seq(
  "org.eclipse.jetty" % "jetty-webapp" % "7.3.0.v20110203" % "jetty",
  "javax.servlet" % "servlet-api" % "2.5" % "provided->default"
)


  
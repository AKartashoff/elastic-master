name := "elastic-master"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "commons-httpclient" % "commons-httpclient" % "3.1",
  "org.webjars" %% "webjars-play" % "2.2.2",
  "org.webjars" % "bootstrap" % "2.3.1",
  "org.jgrapht" % "jgrapht-core" % "0.9.0",
  "org.apache.velocity" % "velocity" % "1.7",
  "net.minidev" % "json-smart" % "1.0.9",
  "commons-lang" % "commons-lang" % "2.6",
  "com.amazonaws" % "aws-java-sdk" % "1.9.0",
  "net.sf.opencsv" % "opencsv" % "2.3",
  "org.hibernate" % "hibernate-entitymanager" % "5.0.7.Final",
  "com.sun.xml.bind" % "jaxb-impl" % "2.2.10"
)     

play.Project.playJavaSettings

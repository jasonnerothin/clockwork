name := "clockwork"

version := "0.0.1"

organization := "com.jasonnerothin"

scalaVersion := "2.9.2"

resolvers ++= Seq(
                    "snapshots"   at "http://oss.sonatype.org/content/repositories/snapshots",
                    "releases"    at "http://oss.sonatype.org/content/repositories/releases",
                    "central"     at "http://repo1.maven.org/maven2"
                )

scalacOptions ++= Seq("-deprecation", "-unchecked")

retrieveManaged := true

libraryDependencies ++= {
  val jodaConvertVersion = "1.2"
  val jodaTimeVersion   = "2.0"
  val junitVersion      = "4.8.2"
  val logbackVersion    = "1.0.6"
  val mockitoVersion    = "1.9.0"
  val scalaTestVersion  = "1.8"
  Seq(
    "ch.qos.logback"    % "logback-classic"         % logbackVersion            % "compile",
    "joda-time"         % "joda-time"               % jodaTimeVersion           % "compile",
    "org.joda"          % "joda-convert"            % jodaConvertVersion        % "compile",
    "junit"             % "junit"                   % junitVersion              % "test",
    "org.mockito"       % "mockito-all"             % mockitoVersion            % "test",
    "org.scalatest"     % "scalatest_2.9.2"         % scalaTestVersion          % "test"
  )
}


name := "ScalaPlaySample"
 
version := "1.0" 
      
lazy val `scalaplaysample` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"
scalaVersion := "2.12.6"


resolvers += "Typesafe Public Repo" at "http://repo.typesafe.com/typesafe/releases"

resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"


libraryDependencies ++= Seq( jdbc , ehcache , ws , specs2 % Test , guice )

libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "2.4.0"


unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )


      
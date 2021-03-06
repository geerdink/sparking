package nl.ing.api

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import spray.can.Http
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import akka.actor.ActorSystem


object Main extends App {

  // we need an ActorSystem to host our application in
  implicit val system = ActorSystem("sparkingAPI")


  // create and start our service actor
  val service = system.actorOf(Props[APIService], "sparking-api-service")

  implicit val timeout = Timeout(10.seconds)
  // start a new HTTP server on port 8081 with our service actor as the handler
//  IO(Http) ? Http.Bind(service, interface = "172.16.33.169", port = 8085)
  IO(Http) ? Http.Bind(service, interface = "172.16.33.16", port = 8085)

}

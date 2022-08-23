package src.test.scala.VideoGameDb

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._


class MyFirstGatlingScript extends Simulation{

  // 1 Http configuration

  val httpProtocol = http.baseUrl("https://videogamedb.uk/api").acceptHeader("application/json")
  // 2 Scenarios Definition

  val scn = scenario("MyFirst Test")
    .exec(http(requestName = "Get all games")
    .get("/videogame"))

  // 3 Load Scenario

  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}

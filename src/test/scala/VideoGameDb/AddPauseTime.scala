package src.test.scala.VideoGameDb

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._


class AddPauseTime extends Simulation{

  // 1 Http configuration

  val httpProtocol = http.baseUrl("https://videogamedb.uk/api").acceptHeader("application/json")
  // 2 Scenarios Definition

  val scn = scenario("adding pause inbetween - 3 calls")

    .exec(http(requestName = "Get all games - 1st call ")
      .get("/videogame"))
      .pause(5) //pause for 5 secs

    .exec(http(requestName = "Get specific game - 2nd call ")
      .get("/videogame/2"))
    .pause(1,10) //random pause in between 1 to 10 secs


    .exec(http(requestName = "Get all games again - 3rd  call ")
      .get("/videogame"))
    .pause(3000.millisecond) //specifying how long to wait


  // 3 Load Scenario

  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}


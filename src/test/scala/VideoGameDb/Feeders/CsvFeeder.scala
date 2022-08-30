package VideoGameDb.Feeders

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class CsvFeeder extends Simulation {

  // 1 Http configuration

  val httpProtocol = http.baseUrl("https://videogamedb.uk/api")
    .acceptHeader("application/json")
  // 2 Scenarios Definition
  // 2 Scenarios Definition

  val csvFeeder = csv("Data/gameCsvFileVG.csv").circular

  def getSpecificVideoGame()= {
    repeat(3) {
      feed(csvFeeder)
        .exec(http(requestName = "get specific Videogame ${gameName}")
          .get("/videogame/${gameId}")
          //.check(jsonPath("$.name").is(expected ="#{gameName}"))
          //.check(status.is(expected = 200)))
          .check(bodyString.saveAs("responseBody")))

        //Printing the value on console
        .exec { session => println(session("responseBody").as[String]); session }

        .pause(5)
    }
  }

  val scn = scenario("CSV Feeder Test ")

    .exec(getSpecificVideoGame())


    // 3 Load Scenario

    setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)


}

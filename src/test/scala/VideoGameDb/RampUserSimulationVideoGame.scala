package VideoGameDb

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RampUserSimulationVideoGame extends Simulation {

  val httpProtocol = http.baseUrl("https://videogamedb.uk")
    .acceptHeader("application/json")

  def getAllVideoGames() = {
    exec(http("Get all video games")
      .get("/api/videogame")
      .check(bodyString.saveAs("responseBody"))
    )
      //Printing the value on console
      .exec { session => println(session("responseBody").as[String]); session }

  }

  def getSpecificVideoGame() = {
    exec(http("Get Specific video games")
      .get("/videogame/2"))
    // check (bodyString.saveAs("responseBody"))
    // )
    //Printing the value on console
    //   .exec { session => println(session("responseBody").as[String]); session }
  }

  val scn = scenario("Ramp Users Load Simulation")
    .exec(getAllVideoGames())
    .pause(5)
    .exec(getSpecificVideoGame())
    .pause(5)

  setUp(scn.
    inject(
      nothingFor(5),
      constantUsersPerSec(10).during(10),
      rampUsersPerSec(5).to(10).during(10))
    .protocols(httpProtocol))
}


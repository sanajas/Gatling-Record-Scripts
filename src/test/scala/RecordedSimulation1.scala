package computerdatabase

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

// basic Gatling imports
//import io.Gatling.core.Predef._
//import io.Gatling.http.Predef._


// 1. every scenario class should extend from Simulation class
class RecordedSimulation1 extends Simulation{

  // 2. define protocol
  val httpProtocol = http
    .baseUrl("https://reqres.in")
    .acceptHeader("application/json")


  // 3. define scenario
  def createUsers() = {
    exec(http("create a user")
      .post("/api/users")
      .body(StringBody(
        """
          |{"name":"bob","job":"painter"}
          """.stripMargin)).asJson)
  }

  val scn = scenario("create list of users")
    .exec(createUsers())

  // 4. setup scenario with load profile for execution
  setUp(scn.inject(atOnceUsers(1))
    .protocols(httpProtocol))

}
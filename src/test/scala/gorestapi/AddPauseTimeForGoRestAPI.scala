package src.test.scala.gorestapi


import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration
import io.gatling.jdbc.Predef._

class AddPauseTimeForGoRestAPI extends Simulation {

  // 1 Http configuration

  val httpConf = http.baseUrl("https://gorest.co.in")
    .header("Authorization", "Bearer 17a2fa9c5c6101cedf04769fae539c2677a70bf7edc485c093469e91f928d9e7")

  // 2 Scenarios Definition

  val scn = scenario("adding pause inbetween - 3 calls")

    .exec(http(requestName = "Get all Users in api - First call")
      .get("/public-api/users")
      .check(bodyString.saveAs("responseBody")))
    .exec { session => println(session("responseBody").as[String]); session }
    .pause(5)

    .exec(http(requestName = "Get all Users in api - Second call")
      .get("/public-api/users/2")
      .check(bodyString.saveAs("responseBody")))
    .exec { session => println(session("responseBody").as[String]); session }
    .pause(3,10)

    .exec(http(requestName = "Get all Users in api - Third call")
      .get("/public-api/users/2399")
     .check(bodyString.saveAs("responseBody")))
    .exec { session => println(session("responseBody").as[String]); session }


  // 3 Load Scenario

  setUp(scn.inject(atOnceUsers(1))).protocols(httpConf)
}


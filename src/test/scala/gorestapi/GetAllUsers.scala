package src.test.scala.gorestapi

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._


class GetAllUsers extends Simulation{

  // 1 Http configuration

  val httpConf = http.baseUrl("https://gorest.co.in")
    .header("Authorization", "Bearer 17a2fa9c5c6101cedf04769fae539c2677a70bf7edc485c093469e91f928d9e7")

  // 2 Scenarios Definition

  val scn = scenario("My First Get users API Test")
    .exec(http(requestName = "Get all Users API")
      .get("/public-api/users"))

  // 3 Load Scenario

  setUp(scn.inject(atOnceUsers(1))).protocols(httpConf)
}
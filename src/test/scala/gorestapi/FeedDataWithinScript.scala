package src.test.scala.gorestapi


import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

import scala.io.Codec.fallbackSystemCodec.name

// basic Gatling imports
//import io.Gatling.core.Predef._
//import io.Gatling.http.Predef._


// 1. every scenario class should extend from Simulation class
class FeedDataWithinScript extends Simulation{


  val httpConf = http.baseUrl("https://gorest.co.in")
    .header("Authorization","Bearer 17a2fa9c5c6101cedf04769fae539c2677a70bf7edc485c093469e91f928d9e7")

//Generating user id programatically within the script

  //variable to hold the numbers generated below

  val userId = (2100 to 2110).iterator

  //create feeder containing user id numbers

  val customFeeder = Iterator.continually(Map("userId" -> userId.next()))


  def getuserID()={
    repeat(10){
      feed(customFeeder)
        .exec(http("get user ids ${userId}")
          .get("/public-api/users/${userId}")
          //.check(jsonPath("$.data.name").is("${name}"))
          .check(status.in(200)))
        .pause(5)


    }

  }




  val scn = scenario("Script - retrieving test data within script ")
    .exec(getuserID())


  // 4. setup scenario with load profile for execution
  setUp(scn.inject(atOnceUsers(1))).protocols(httpConf)

}
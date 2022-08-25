package src.test.scala.gorestapi

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration
import io.gatling.jdbc.Predef._

import scala.Console.println

class CheckResponseExtractNPrint extends Simulation {

  // 1 Http configuration

  val httpConf = http.baseUrl("https://gorest.co.in")
    .header("Authorization", "Bearer 17a2fa9c5c6101cedf04769fae539c2677a70bf7edc485c093469e91f928d9e7")

  // 2 Scenarios Definition

  val scn = scenario("Checking the response in json path")


    .exec(http(requestName = "Get one user data ")
      .get("/public-api/users/2399")
      .check(status.is(expected = 200)) // checking incorrect user id
      .check(jsonPath(path = "$.data.name").is(expected = "The Hon. Charuchandra Tagore")))

      //saving the value in some variable
        .exec(http(requestName = "Get all user data and save one data in some variable ")
        .get("/public-api/users/")
        .check(jsonPath(path = "$..1.id").saveAs("UserId")))

    //Printing the value on console
        .exec { session =>   println( session ); session }

//Passing the saved variable name into next code
      .exec(http(requestName = "Get all userid which was saved in variable and compare the value ")
      .get("/public-api/${UserId}")
      .check(jsonPath(path = "$..1.name").is(expected = "Aatreya Guha"))
      .check(bodyString.saveAs("responseBody")))

    //Printing the value on console
      .exec { session =>   println( session ("responseBody").as[String]); session }



        //printing the name of the variable compared

  //.exec(http(requestName = "Get all Users in api - Third call")
  // .get("/public-api/users/2997")
  // .check(status.not(expected = 404))
  //.check(bodyString.saveAs("responseBody")))
  //.exec { session => println(session("responseBody").as[String]); session }


  // 3 Load Scenario

  setUp(scn.inject(atOnceUsers(1))).protocols(httpConf)
}



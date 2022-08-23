
package computerdatabase

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

import scala.io.Codec.fallbackSystemCodec.name

// basic Gatling imports
//import io.Gatling.core.Predef._
//import io.Gatling.http.Predef._


// 1. every scenario class should extend from Simulation class
class FeedcsvFile extends Simulation{


  val httpConf = http.baseUrl("https://gorest.co.in")
    .header("Authorization","Bearer 17a2fa9c5c6101cedf04769fae539c2677a70bf7edc485c093469e91f928d9e7")


  val csvFeeder = csv("src/test/scala/Data/Inputdatacsv.csv").circular

  def getAUser()={
    repeat(2){
      feed(csvFeeder)
      .exec(http("get a single user request ${userid}")
        .get("/public-api/users/${userid}")
        .check(jsonPath("$.data.name").is("${name}"))
        .check(status.in(200,304))
        .check(bodyString.saveAs("responseBody")))
        .exec { session => println(session("responseBody").as[String]); session }


    }

  }




  val scn = scenario("csv file reader ").exec(getAUser())


  // 4. setup scenario with load profile for execution
  setUp(scn.inject(atOnceUsers(1))).protocols(httpConf)

}
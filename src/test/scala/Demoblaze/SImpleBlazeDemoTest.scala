package Demoblaze

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class SImpleBlazeDemoTest extends Simulation {

  val httpProtocol = http.baseUrl("http://api-demoblaze.com")
   // .inferHtmlResources()
  //.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
  //.acceptEncodingHeader("gzip, deflate")
  //.acceptLanguageHeader("vi,en-US;q=0.9,en;q=0.8")
  //.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")



  val scn = scenario("DemoBlaze cart")
    .exec(http("request_0")
      .get("/cart.html"))
  //.headers(headers_0))


  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)

}
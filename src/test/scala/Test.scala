package computerdatabase

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

  private val httpProtocol = http
    .baseUrl("https://computer-database.gatling.io")
    //.inferHtmlResources(AllowList(), DenyList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""))
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-GB,en-US;q=0.9,en;q=0.8")
    .upgradeInsecureRequestsHeader("1")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36")

  private val headers_0 = Map(
    "Cache-Control" -> "max-age=0",
    "Sec-Fetch-Dest" -> "document",
    "Sec-Fetch-Mode" -> "navigate",
    "Sec-Fetch-Site" -> "none",
    "Sec-Fetch-User" -> "?1",
    "sec-ch-ua" -> """Chromium";v="104", " Not A;Brand";v="99", "Google Chrome";v="104""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-ch-ua-platform" -> "macOS"
  )

  private val headers_1 = Map(
    "Sec-Fetch-Dest" -> "document",
    "Sec-Fetch-Mode" -> "navigate",
    "Sec-Fetch-Site" -> "same-origin",
    "Sec-Fetch-User" -> "?1",
    "sec-ch-ua" -> """Chromium";v="104", " Not A;Brand";v="99", "Google Chrome";v="104""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-ch-ua-platform" -> "macOS"
  )

  private val headers_2 = Map(
    "Cache-Control" -> "max-age=0",
    "Origin" -> "https://computer-database.gatling.io",
    "Sec-Fetch-Dest" -> "document",
    "Sec-Fetch-Mode" -> "navigate",
    "Sec-Fetch-Site" -> "same-origin",
    "Sec-Fetch-User" -> "?1",
    "sec-ch-ua" -> """Chromium";v="104", " Not A;Brand";v="99", "Google Chrome";v="104""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-ch-ua-platform" -> "macOS"
  )


  private val scn = scenario("RecordedSimulation")
    .exec(
      http("Load Homepage")
        .get("/computers")
        .headers(headers_0)
    )
    .pause(2)
    .exec(
      http("Click New Computer")
        .get("/computers/new")
        .headers(headers_1)
    )
    .pause(13)
    .exec(
      http("Create New Computer")
        .post("/computers")
        .headers(headers_2)
        .formParam("name", "mytest1")
        .formParam("introduced", "2022-01-01")
        .formParam("discontinued", "2022-02-01")
        .formParam("company", "1")
    )

  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}

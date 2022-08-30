package Demoblaze


import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class BasicLoadSimulationTestDemoBlaze extends Simulation {

  private val httpProtocol = http
    .baseUrl("https://www.demoblaze.com")
    //.inferHtmlResources(AllowList(), DenyList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""))

  private val HomePage = Map(
    "accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "sec-ch-ua" -> """Chromium";v="104", " Not A;Brand";v="99", "Google Chrome";v="104""",
    "sec-ch-ua-arch" -> "x86",
    "sec-ch-ua-bitness" -> "64",
    "sec-ch-ua-full-version" -> "104.0.5112.101",
    "sec-ch-ua-mobile" -> "?0",
    "sec-ch-ua-model" -> "",
    "sec-ch-ua-platform" -> "macOS",
    "sec-fetch-dest" -> "document",
    "sec-fetch-mode" -> "navigate",
    "sec-fetch-site" -> "none",
    "sec-fetch-user" -> "?1",
    "upgrade-insecure-requests" -> "1",
    "user-agent" -> "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36"
  )

  private val ViewHomePage = Map(
    "accept" -> "application/json, text/javascript, */*; q=0.01",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "sec-ch-ua" -> """Chromium";v="104", " Not A;Brand";v="99", "Google Chrome";v="104""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-ch-ua-platform" -> "macOS",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin",
    "user-agent" -> "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36",
    "x-requested-with" -> "XMLHttpRequest"
  )

  private val headers_5 = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "origin" -> "https://www.demoblaze.com",
    "sec-ch-ua" -> """Chromium";v="104", " Not A;Brand";v="99", "Google Chrome";v="104""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-ch-ua-platform" -> "macOS",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-site",
    "user-agent" -> "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36"
  )

  private val headers_6 = Map(
    "accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "sec-ch-ua" -> """Chromium";v="104", " Not A;Brand";v="99", "Google Chrome";v="104""",
    "sec-ch-ua-arch" -> "x86",
    "sec-ch-ua-bitness" -> "64",
    "sec-ch-ua-full-version" -> "104.0.5112.101",
    "sec-ch-ua-mobile" -> "?0",
    "sec-ch-ua-model" -> "",
    "sec-ch-ua-platform" -> "macOS",
    "sec-fetch-dest" -> "document",
    "sec-fetch-mode" -> "navigate",
    "sec-fetch-site" -> "same-origin",
    "sec-fetch-user" -> "?1",
    "upgrade-insecure-requests" -> "1",
    "user-agent" -> "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36"
  )

  private val Category = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "access-control-request-headers" -> "content-type",
    "access-control-request-method" -> "POST",
    "origin" -> "https://www.demoblaze.com",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-site",
    "user-agent" -> "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36"
  )

  private val SelectOption = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "application/json",
    "origin" -> "https://www.demoblaze.com",
    "sec-ch-ua" -> """Chromium";v="104", " Not A;Brand";v="99", "Google Chrome";v="104""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-ch-ua-platform" -> "macOS",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-site",
    "user-agent" -> "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36"
  )

  private val uri2 = "https://api.demoblaze.com"

  //private val uri3 = "https://hls.demoblaze.com"

  private val scn = scenario("BasicLoad Simulation")
    .exec(
      http("Home Page")
        .get("/")
        .headers(HomePage)
        .resources(
          http("Home Landing Page")
            .get("/config.json")
            .headers(ViewHomePage),

        )
    )
    .pause(2)
    .exec(
      http("BrowseBy_Category")
        .options(uri2 + "/bycat")
        .headers(Category)
        .resources(
          http("Selecting1_Option")
            .post(uri2 + "/bycat")
            .headers(SelectOption)
            .body(RawFileBody("src/test/scala/JsonData/Category.json")))
            .check(bodyString.saveAs("responseBody"))
    )
        //Printing the value on console
        .exec { session => println(session("responseBody").as[String]); session }


    .pause(3)
    .exec(
      http("Product Listing Page")
        .get("/prod.html?idp_=1")
        .headers(headers_6)
        .resources(
          http("Clicking on product")
            .get("/config.json"),
          http("View_Item")
            .post(uri2 + "/view")
            .headers(SelectOption)
            .body(RawFileBody("src/test/scala/JsonData/Productid.json")))
            .check(bodyString.saveAs("responseBodyId"))
    )
        .exec { session => println(session("responseBodyId").as[String]); session }



  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}

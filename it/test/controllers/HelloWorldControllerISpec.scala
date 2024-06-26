/*
 * Copyright 2024 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers

import org.jsoup.Jsoup
import play.api.http.Status
import utils.IntegrationSpecHelper

class HelloWorldControllerISpec extends IntegrationSpecHelper {

  "GET /" should {
    "return 200" in {
      val result = get("/hello-world")

      result.status shouldBe Status.OK
    }

    "return the correct view" in {
      val result = get("/hello-world")
      val document = Jsoup.parse(result.body)

      result.contentType shouldBe "text/html; charset=UTF-8"

      document.title shouldBe "boiled-sweet-tax-registration-frontend"
      document.select("h1").text() shouldBe "boiled-sweet-tax-registration-frontend"
      document.select("p.govuk-body").text() shouldBe "This is your new service"
    }
  }

}

$if(enable_packaged.truthy)$
$"package "$$organization$.$name;format="snake" $

$endif$
import $if(enable_packaged.truthy)$$organization$.$name;format="snake"$.$endif$controllers.SampleController
import org.scalatestplus.play.PlaySpec
import play.api.mvc.{Result, Results}
import play.api.test.Helpers._
import play.api.test.{FakeRequest, Helpers}

import scala.concurrent.Future

class SampleControllerSpec extends PlaySpec with Results {

  "SampleController#get" should {

    val controller = new SampleController(Helpers.stubControllerComponents())

    "クエリパラメータ通りのレスポンスを返す" in {
      val name = "world"
      val result: Future[Result] = controller.get(Some(name)).apply(FakeRequest())
      val bodyText = Helpers.contentAsString(result)
      bodyText mustBe "Hello $"$"$name!"
    }

    "クエリパラメータが存在しなかった場合にはエラーメッセージを返す" in {
      val result: Future[Result] = controller.get(None)(FakeRequest())
      val bodyText = contentAsString(result)
      bodyText mustBe """"name"パラメータを指定してください"""
    }
  }
}
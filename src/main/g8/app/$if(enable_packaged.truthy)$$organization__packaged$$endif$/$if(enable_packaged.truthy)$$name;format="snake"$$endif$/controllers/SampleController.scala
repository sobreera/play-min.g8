package $if(enable_packaged.truthy)$$organization$.$name;format="snake"$.$endif$controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, Request, AnyContent, ControllerComponents}

@Singleton
class SampleController @Inject()(c: ControllerComponents) extends AbstractController(c) {

  def get(name: Option[String]) = Action { implicit request: Request[AnyContent] =>
    Ok {
      name
        .map(s => s"Hello $"$"$s!")
        .getOrElse(""""name"パラメータを指定してください""")
    }
  }
}
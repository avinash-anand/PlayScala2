package controllers

import play.api.Play.current
import play.api.libs.ws.WS
import play.api.mvc._

import scala.concurrent.ExecutionContext.Implicits.global

object Application extends Controller {

  def index1 = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def index = Action.async {
      val call1 = WS.url("https://www.google.com").get()
      for {
        response <- call1
      } yield {
        Ok(response.body)
      }
  }

}
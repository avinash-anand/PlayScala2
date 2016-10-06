package controllers

import play.api.mvc.{Action, Controller}
import utils.FileUtils

object RegistrationController extends Controller {

  private val basePath = "conf/resources/"

  def registration(id: Int) = Action.async { implicit request =>
    FileUtils.getFile(basePath + "registration" + id + ".json")
  }

  def submit = Action.async { implicit request =>
    FileUtils.getFile(basePath + "registration123456789.json")
  }

  def put = Action.async { implicit request =>
    FileUtils.getFile(basePath + "registration_put.json")
  }

  def delete(id: Int) = Action.async { implicit request =>
    FileUtils.getFile(basePath + "registration" + id + ".json")
  }

}

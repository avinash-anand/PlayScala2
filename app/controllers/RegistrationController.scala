package controllers

import play.api.Logger
import play.api.mvc.{Action, Controller}
import utils.FileUtils

object RegistrationController extends Controller {

  private val basePath = "conf/resources/"

  def registration(id: Int) = Action.async { implicit request =>
    Logger.info(s"Inside GET Request - ID - $id ; request-headers - ${request.headers}")
    FileUtils.getFile(basePath + "registration" + id + ".json")
  }

  def submit = Action.async { implicit request =>
    Logger.info(s"Inside POST request ; request-headers - ${request.headers}")
    FileUtils.getFile(basePath + "registration123456789.json")
  }

  def put = Action.async { implicit request =>
    Logger.info(s"Inside PUT request ; request-headers - ${request.headers}")
    FileUtils.getFile(basePath + "registration_put.json")
  }

  def delete(id: Int) = Action.async { implicit request =>
    Logger.info(s"Inside DELETE request - ID - $id ; request-headers - ${request.headers} ## ${request.body}")
    FileUtils.getFile(basePath + "registration" + id + ".json")
  }

}

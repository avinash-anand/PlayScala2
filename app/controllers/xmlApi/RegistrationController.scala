package controllers.xmlApi

import play.api.Logger
import play.api.mvc.{Action, AnyContent, Controller}
import utils.FileUtils

object RegistrationController extends Controller {

  private val basePath = "conf/resources/xml/"

  def registration(id: Int): Action[AnyContent] = Action.async { implicit request =>
    Logger.info(s"Inside GET XML Request - ID - $id ; request-headers - ${request.headers}")
    FileUtils.getXmlFile(basePath + "registration" + id + ".xml")
  }

}

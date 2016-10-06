package utils

import java.io.File

import play.api.Play.current
import play.api._
import play.api.http.{ContentTypes, MimeTypes}
import play.api.mvc._

import scala.concurrent.Future

object FileUtils extends Results with ContentTypes {

  def getFile(filePath: String) = {
    Logger.info("[FileUtils][getFile] filePath - " + filePath)
    try {
      val file: File = Play.application.getFile(filePath)

      val source = scala.io.Source.fromFile(file)
      val htmlData = source.mkString
      source.close()
      Future.successful(
        dataAsResponse(Some(htmlData))
      )
    } catch {
      case e: Exception => Future.successful(NotFound("{\"statusCode\": 404, \"message\": \"Not Found\"}").as(MimeTypes.JSON))
    }
  }

  private[utils] def dataAsResponse(data: Option[String]): Result = {
    //package private for test coverage
    data match {
      case Some(content) if content.isEmpty => NoContent
      case Some(content) if content.contains("\"statusCode\": 400") => BadRequest(content).as(MimeTypes.JSON)
      case Some(content) if content.contains("\"statusCode\": 403") => Forbidden(content).as(MimeTypes.JSON)
      case Some(content) if content.contains("\"statusCode\": 500") => InternalServerError(content).as(MimeTypes.JSON)
      case Some(content) => Ok(content).as(MimeTypes.JSON)
      case _ => NotFound("{\"statusCode\": 404, \"message\": \"Not Found\"}").as(MimeTypes.JSON)
    }
  }

}

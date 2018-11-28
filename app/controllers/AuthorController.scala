package controllers

import javax.inject.{Inject, Singleton}
import play.api.libs.json._
import play.api.mvc.{Action, InjectedController}
import repositories.AuthorRepository

import scala.concurrent.ExecutionContext

@Singleton
class AuthorController @Inject() (repos: AuthorRepository) (implicit ec: ExecutionContext)
  extends InjectedController {

  def select(): Action[JsValue] = Action.async(parse.json) { _ =>
    val response = repos.read()
    response.map(seq => Ok(Json.toJson(seq)))
  }
}

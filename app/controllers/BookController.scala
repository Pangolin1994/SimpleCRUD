package controllers

import javax.inject.{Inject, Singleton}
import models.{Book, Author}
import play.api.libs.json._
import play.api.mvc.{Action, InjectedController}
import repositories.{AuthorRepository, BookRepository}
import slick.lifted.Rep

import scala.concurrent.ExecutionContext

@Singleton
class BookController @Inject()(repos: BookRepository, authorRepos: AuthorRepository)
                              (implicit ec: ExecutionContext) extends InjectedController {

  def add(): Action[JsValue] = Action.async(parse.json) { request =>
    val book = request.body
    val entity = Json.fromJson[Book](book).get
    // Check for existense added author
    val authorsLength = (for {
      author <- authorRepos.authors if author.name == entity.author
    } yield author).length
    if (authorsLength == Rep[Int](0))
      authorRepos.create(Author(Int(authorsLength), entity.author))
    // End check
    val response = repos.create(entity)
    response.map(_ => Ok(Json.toJson(entity)))
  }

  def select(): Action[JsValue] = Action.async(parse.json) { _ =>
    val response = for {
      book <- repos.read()
    } yield book
    response.map(a => Ok(Json.toJson(a))).recover {
      case _: Exception => InternalServerError
    }
  }

  def update(id: Int): Action[JsValue] = Action.async(parse.json) { request =>
    val newBook = request.body
    val entity = Json.fromJson[Book](newBook).get
    val response = repos.update(id, entity)
    response.map(_ => Ok(Json.toJson(entity)))
  }

  def delete(Id: Int): Action[JsValue] = Action.async(parse.json) { _ =>
    val response = repos.deleteById(Id)
    response.map(e => Ok(Json.toJson(e)))
  }
}

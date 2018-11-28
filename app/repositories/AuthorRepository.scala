package repositories

import javax.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import play.db.NamedDatabase
import slick.jdbc.JdbcProfile
import mainpackage.DBRunner._
import models.{Author, Authors}

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class AuthorRepository @Inject() (@NamedDatabase("Authors") val dbCfgProvider: DatabaseConfigProvider) (implicit ec: ExecutionContext){
  val dbConfig = dbCfgProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  type author_type = Authors#TableElementType

  val authors = TableQuery[Authors]
  val queryById = Compiled((id: Rep[Int]) => authors.filter(_.id === id))
  val queryByName = Compiled((name: Rep[String]) => authors.filter(_.name === name))

  def readById(id: Int): Future[Author] = {
    queryById(id).result.head
  }

  def read(): Future[Seq[author_type]] = {
    authors.result
  }

  def create(author: author_type): Future[Int] = {
    authors += author
  }

  def update(id: Int, author: author_type): Future[Int] = {
    val updateTarget = for {elem <- authors if elem.id === id} yield elem
    updateTarget.update(author)
  }

  def deleteById(id: Int): Future[Int] = {
    queryById(id).delete
  }

  def delete(): Future[Int] = {
    authors.delete
  }
}

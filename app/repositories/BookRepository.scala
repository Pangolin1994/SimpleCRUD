package repositories

import javax.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import play.db.NamedDatabase
import slick.jdbc.JdbcProfile
import mainpackage.DBRunner._
import models.{Book, Books}

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class BookRepository @Inject()(@NamedDatabase("Books") val dbCfgProvider: DatabaseConfigProvider)
                              (implicit ec: ExecutionContext) {
  val dbConfig = dbCfgProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  type book_type = Books#TableElementType

  val books = TableQuery[Books]
  val queryById = Compiled((id: Rep[Int]) => books.filter(_.id === id))

  def readById(id: Int): Future[Book] = {
    queryById(id).result.head
  }

  def read(): Future[Seq[book_type]] = {
    books.result
  }

  def create(book: book_type): Future[Int] = {
    books += book
  }

  def update(id: Int, author: book_type): Future[Int] = {
    val updateTarget = for {elem <- books if elem.id === id} yield elem
    updateTarget.update(author)
  }

  def deleteById(id: Int): Future[Int] = {
    queryById(id).delete
  }

  def delete(): Future[Int] = {
    books.delete
  }
}

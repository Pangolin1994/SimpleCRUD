package models

import slick.jdbc.SQLServerProfile.api._
import slick.lifted.ProvenShape
import play.api.libs.json._

case class Book(id: Int, title: String, year: Int, author: String)

object Book {
  implicit val jsonToBook: OFormat[Book] = Json.format[Book]
}

class Books(tag: Tag) extends Table[Book](tag, "Books"){
  def id: Rep[Int] = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def title: Rep[String] = column[String]("title")
  def year: Rep[Int] = column[Int]("year")
  def author: Rep[String] = column[String]("author")

  def * : ProvenShape[Book] = (id, title, year, author) <> ((Book.apply _).tupled, Book.unapply)
}


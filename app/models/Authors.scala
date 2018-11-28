package models

import slick.jdbc.SQLServerProfile.api._
import slick.lifted.ProvenShape
import play.api.libs.json._

case class Author(id: Int, name: String)

object Author {
  implicit val jsonToAuthor: OFormat[Author] = Json.format[Author]
}

class Authors(tag: Tag) extends Table[Author](tag, "Authors") {
  def id : Rep[Int] = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def name : Rep[String] = column[String]("name")

  def * : ProvenShape[Author] = (id, name) <> ((Author.apply _).tupled, Author.unapply)
}

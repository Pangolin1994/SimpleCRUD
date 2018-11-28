package mainpackage

import scala.concurrent.Future
import slick.jdbc.SQLServerProfile.api.Database
import slick.dbio.DBIO

object DBRunner {
  val db: Database  = Database.forConfig("mssql")
  implicit def execute[T](dbOperation: DBIO[T]): Future[T] = {
    db.run(dbOperation)
  }
}

// @GENERATOR:play-routes-compiler
// @SOURCE:D:/ScalaProjects/CRUDApp/conf/routes
// @DATE:Wed Nov 28 16:23:05 MSK 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:1
  BookController_0: controllers.BookController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:1
    BookController_0: controllers.BookController
  ) = this(errorHandler, BookController_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, BookController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.BookController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """create""", """controllers.BookController.add"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """read""", """controllers.BookController.select"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """update/{id}""", """controllers.BookController.update(id:Int)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """remove/{id}""", """controllers.BookController.remove(id:Int)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:1
  private[this] lazy val controllers_BookController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_BookController_index0_invoker = createInvoker(
    BookController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BookController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:2
  private[this] lazy val controllers_BookController_add1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("create")))
  )
  private[this] lazy val controllers_BookController_add1_invoker = createInvoker(
    BookController_0.add,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BookController",
      "add",
      Nil,
      "POST",
      this.prefix + """create""",
      """""",
      Seq()
    )
  )

  // @LINE:3
  private[this] lazy val controllers_BookController_select2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("read")))
  )
  private[this] lazy val controllers_BookController_select2_invoker = createInvoker(
    BookController_0.select,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BookController",
      "select",
      Nil,
      "GET",
      this.prefix + """read""",
      """""",
      Seq()
    )
  )

  // @LINE:4
  private[this] lazy val controllers_BookController_update3_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("update/{id}")))
  )
  private[this] lazy val controllers_BookController_update3_invoker = createInvoker(
    BookController_0.update(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BookController",
      "update",
      Seq(classOf[Int]),
      "PUT",
      this.prefix + """update/{id}""",
      """""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val controllers_BookController_remove4_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("remove/{id}")))
  )
  private[this] lazy val controllers_BookController_remove4_invoker = createInvoker(
    BookController_0.remove(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BookController",
      "remove",
      Seq(classOf[Int]),
      "DELETE",
      this.prefix + """remove/{id}""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:1
    case controllers_BookController_index0_route(params@_) =>
      call { 
        controllers_BookController_index0_invoker.call(BookController_0.index)
      }
  
    // @LINE:2
    case controllers_BookController_add1_route(params@_) =>
      call { 
        controllers_BookController_add1_invoker.call(BookController_0.add)
      }
  
    // @LINE:3
    case controllers_BookController_select2_route(params@_) =>
      call { 
        controllers_BookController_select2_invoker.call(BookController_0.select)
      }
  
    // @LINE:4
    case controllers_BookController_update3_route(params@_) =>
      call(params.fromQuery[Int]("id", None)) { (id) =>
        controllers_BookController_update3_invoker.call(BookController_0.update(id))
      }
  
    // @LINE:5
    case controllers_BookController_remove4_route(params@_) =>
      call(params.fromQuery[Int]("id", None)) { (id) =>
        controllers_BookController_remove4_invoker.call(BookController_0.remove(id))
      }
  }
}

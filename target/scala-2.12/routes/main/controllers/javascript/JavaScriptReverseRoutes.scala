// @GENERATOR:play-routes-compiler
// @SOURCE:D:/ScalaProjects/CRUDApp/conf/routes
// @DATE:Wed Nov 28 16:23:05 MSK 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers.javascript {

  // @LINE:1
  class ReverseBookController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:4
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BookController.update",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "update/{id}" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("id", id0)])})
        }
      """
    )
  
    // @LINE:3
    def select: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BookController.select",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "read"})
        }
      """
    )
  
    // @LINE:2
    def add: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BookController.add",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "create"})
        }
      """
    )
  
    // @LINE:1
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BookController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:5
    def remove: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BookController.remove",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "remove/{id}" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("id", id0)])})
        }
      """
    )
  
  }


}

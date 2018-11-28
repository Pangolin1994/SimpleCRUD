// @GENERATOR:play-routes-compiler
// @SOURCE:D:/ScalaProjects/CRUDApp/conf/routes
// @DATE:Wed Nov 28 16:23:05 MSK 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers {

  // @LINE:1
  class ReverseBookController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:4
    def update(id:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "update/{id}" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("id", id)))))
    }
  
    // @LINE:3
    def select(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "read")
    }
  
    // @LINE:2
    def add(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "create")
    }
  
    // @LINE:1
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:5
    def remove(id:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "remove/{id}" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("id", id)))))
    }
  
  }


}

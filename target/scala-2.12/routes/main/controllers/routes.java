// @GENERATOR:play-routes-compiler
// @SOURCE:D:/ScalaProjects/CRUDApp/conf/routes
// @DATE:Wed Nov 28 16:23:05 MSK 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseBookController BookController = new controllers.ReverseBookController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseBookController BookController = new controllers.javascript.ReverseBookController(RoutesPrefix.byNamePrefix());
  }

}

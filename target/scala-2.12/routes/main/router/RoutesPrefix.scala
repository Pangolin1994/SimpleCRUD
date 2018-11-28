// @GENERATOR:play-routes-compiler
// @SOURCE:D:/ScalaProjects/CRUDApp/conf/routes
// @DATE:Wed Nov 28 16:23:05 MSK 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}

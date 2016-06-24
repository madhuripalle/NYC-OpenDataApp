
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/madhuripalle/ASE4156/conf/routes
// @DATE:Fri Sep 04 23:58:25 EDT 2015


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

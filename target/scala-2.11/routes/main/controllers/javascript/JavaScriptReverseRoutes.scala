
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/madhuripalle/ASE4156/conf/routes
// @DATE:Fri Sep 04 23:58:25 EDT 2015

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:12
  class ReverseRefuse(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def paper: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Refuse.paper",
      """
        function(borough,commId) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "paper/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("borough", encodeURIComponent(borough)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("commId", encodeURIComponent(commId))})
        }
      """
    )
  
    // @LINE:12
    def refuse: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Refuse.refuse",
      """
        function(borough,commId) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "refuse/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("borough", encodeURIComponent(borough)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("commId", encodeURIComponent(commId))})
        }
      """
    )
  
    // @LINE:15
    def total: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Refuse.total",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "total"})
        }
      """
    )
  
    // @LINE:14
    def mgp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Refuse.mgp",
      """
        function(borough,commId) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mgp/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("borough", encodeURIComponent(borough)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("commId", encodeURIComponent(commId))})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }


}
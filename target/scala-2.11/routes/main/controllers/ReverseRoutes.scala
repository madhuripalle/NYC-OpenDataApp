
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/madhuripalle/ASE4156/conf/routes
// @DATE:Fri Sep 04 23:58:25 EDT 2015

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:12
  class ReverseRefuse(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def paper(borough:String, commId:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "paper/" + implicitly[PathBindable[String]].unbind("borough", dynamicString(borough)) + "/" + implicitly[PathBindable[String]].unbind("commId", dynamicString(commId)))
    }
  
    // @LINE:12
    def refuse(borough:String, commId:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "refuse/" + implicitly[PathBindable[String]].unbind("borough", dynamicString(borough)) + "/" + implicitly[PathBindable[String]].unbind("commId", dynamicString(commId)))
    }
  
    // @LINE:15
    def total(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "total")
    }
  
    // @LINE:14
    def mgp(borough:String, commId:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "mgp/" + implicitly[PathBindable[String]].unbind("borough", dynamicString(borough)) + "/" + implicitly[PathBindable[String]].unbind("commId", dynamicString(commId)))
    }
  
  }

  // @LINE:9
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def at(file:String): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix)
    }
  
  }


}
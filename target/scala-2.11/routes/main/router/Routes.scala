
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/madhuripalle/ASE4156/conf/routes
// @DATE:Fri Sep 04 23:58:25 EDT 2015

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Application_2: controllers.Application,
  // @LINE:9
  Assets_1: controllers.Assets,
  // @LINE:12
  Refuse_0: controllers.Refuse,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_2: controllers.Application,
    // @LINE:9
    Assets_1: controllers.Assets,
    // @LINE:12
    Refuse_0: controllers.Refuse
  ) = this(errorHandler, Application_2, Assets_1, Refuse_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_2, Assets_1, Refuse_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Application.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """refuse/$borough<[^/]+>/$commId<[^/]+>""", """controllers.Refuse.refuse(borough:String, commId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """paper/$borough<[^/]+>/$commId<[^/]+>""", """controllers.Refuse.paper(borough:String, commId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mgp/$borough<[^/]+>/$commId<[^/]+>""", """controllers.Refuse.mgp(borough:String, commId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """total""", """controllers.Refuse.total()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Application_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index0_invoker = createInvoker(
    Application_2.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Assets_at1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at1_invoker = createInvoker(
    Assets_1.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/$file<.+>"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Refuse_refuse2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("refuse/"), DynamicPart("borough", """[^/]+""",true), StaticPart("/"), DynamicPart("commId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Refuse_refuse2_invoker = createInvoker(
    Refuse_0.refuse(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Refuse",
      "refuse",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Routes for COMS W4156 PreAssignment""",
      this.prefix + """refuse/$borough<[^/]+>/$commId<[^/]+>"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Refuse_paper3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("paper/"), DynamicPart("borough", """[^/]+""",true), StaticPart("/"), DynamicPart("commId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Refuse_paper3_invoker = createInvoker(
    Refuse_0.paper(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Refuse",
      "paper",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """paper/$borough<[^/]+>/$commId<[^/]+>"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Refuse_mgp4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mgp/"), DynamicPart("borough", """[^/]+""",true), StaticPart("/"), DynamicPart("commId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Refuse_mgp4_invoker = createInvoker(
    Refuse_0.mgp(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Refuse",
      "mgp",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """mgp/$borough<[^/]+>/$commId<[^/]+>"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Refuse_total5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("total")))
  )
  private[this] lazy val controllers_Refuse_total5_invoker = createInvoker(
    Refuse_0.total(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Refuse",
      "total",
      Nil,
      "GET",
      """""",
      this.prefix + """total"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_2.index())
      }
  
    // @LINE:9
    case controllers_Assets_at1_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at1_invoker.call(Assets_1.at(path, file))
      }
  
    // @LINE:12
    case controllers_Refuse_refuse2_route(params) =>
      call(params.fromPath[String]("borough", None), params.fromPath[String]("commId", None)) { (borough, commId) =>
        controllers_Refuse_refuse2_invoker.call(Refuse_0.refuse(borough, commId))
      }
  
    // @LINE:13
    case controllers_Refuse_paper3_route(params) =>
      call(params.fromPath[String]("borough", None), params.fromPath[String]("commId", None)) { (borough, commId) =>
        controllers_Refuse_paper3_invoker.call(Refuse_0.paper(borough, commId))
      }
  
    // @LINE:14
    case controllers_Refuse_mgp4_route(params) =>
      call(params.fromPath[String]("borough", None), params.fromPath[String]("commId", None)) { (borough, commId) =>
        controllers_Refuse_mgp4_invoker.call(Refuse_0.mgp(borough, commId))
      }
  
    // @LINE:15
    case controllers_Refuse_total5_route(params) =>
      call { 
        controllers_Refuse_total5_invoker.call(Refuse_0.total())
      }
  }
}
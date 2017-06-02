package controllers


import _root_.http.{HttpResult, BasicAuthHandler}
import play.api._
import play.api.libs.json.{JsValue, Json}
import play.api.mvc._

object Application extends Controller {
    def index = Action {
        Ok("success")
    }

}

class ApiController(apiProcessor: ApiProcessor) extends Controller {

    def testNoAuth(testString: String) = Action {
        Ok(Json.obj("Success" -> testString))
    }

    def test(testS: String): Action[JsValue] = Action(parse.json) {request =>
        apiProcessor.test(request, testS)
    }

}

class ApiProcessor(authHandler: BasicAuthHandler) {

    def test(request: Request[Any], testS: String) : Result = {

        authenticateRequest(request) match {
            case Some(result) => return result
            case None => ()
        }


        return HttpResult.getOkResult(Json.obj("Success" -> testS))
    }




    def authenticateRequest(request: Request[Any]): Option[Result] = {
        authHandler.validateAuth(request) match {
            case true => None
            case false => Some(HttpResult.getUnauthorizedResult(Json.obj("error" -> "User is unauthorized")))
        }

    }
}
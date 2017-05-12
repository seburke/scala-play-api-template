package http

import play.api.libs.json.JsValue
import play.api.mvc.{Result, Controller}


object HttpResult extends Controller{

    def getBadRequestResult(message: JsValue) : Result = BadRequest(message)

    def getAcceptedResult(message: JsValue) : Result = Accepted(message)

    def getOkResult(message: JsValue) : Result = Ok(message)

    def getTooManyRequestResult(message: JsValue) : Result = TooManyRequest(message)

    def getUnauthorizedResult(message: JsValue) : Result = Unauthorized(message)

    def getForbiddenResult(message: JsValue) : Result = Forbidden(message)
}
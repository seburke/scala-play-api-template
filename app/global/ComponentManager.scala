package global

import controllers.ApiProcessor
import http.BasicAuthHandlerImpl
import play.api.Play._

class ComponentManager {

    val authHandler = new BasicAuthHandlerImpl(configuration.getString("api.key").get, configuration.getString("api.secret").get)
    val apiProcessor = new ApiProcessor(authHandler)


}

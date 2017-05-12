package plugins

import controllers.ApiController
import global.ComponentManager
import play.{Application, Plugin}
import play.api.Play.current
import scala.concurrent.ExecutionContext.Implicits.global



object LifeCyclePlugin {
    var componentManager : ComponentManager = null
    var apiController: ApiController = null
}

class LifeCyclePlugin(implicit app: Application) extends Plugin {
    override def onStart(): Unit = {
        LifeCyclePlugin.componentManager = new ComponentManager()
        LifeCyclePlugin.apiController = new ApiController(LifeCyclePlugin.componentManager.apiProcessor)
    }

}
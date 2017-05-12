import controllers.ApiController
import play.api.GlobalSettings
import plugins.LifeCyclePlugin

object Global extends GlobalSettings {

    override def getControllerInstance[A](controllerClass: Class[A]): A = {
        if(controllerClass == classOf[ApiController]) {
            controllerClass.cast(LifeCyclePlugin.apiController)
        } else {
            controllerClass.cast(null)
        }
    }
}

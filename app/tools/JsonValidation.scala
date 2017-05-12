package tools

import play.api.libs.json.{JsObject, Reads}


object JsonValidation {

    def onlyFields(allowed: String*): Reads[JsObject] =
        Reads.verifying(_.keys.forall(allowed.contains))

}

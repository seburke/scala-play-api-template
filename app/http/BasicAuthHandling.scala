package http

import play.api.mvc.Request
import org.apache.commons.codec.binary.Base64._

trait BasicAuthHandler {

    def getBasicAuth(request: Request[Any]): Option[(String, String)] = {
        for {
            header <- request.headers.get("Authorization") if header.startsWith("Basic ")
            apiAuth <- decodeAuthHeaderValue(header)
        } yield apiAuth
    }

    def decodeAuthHeaderValue(header: String): Option[(String, String)] = {
        val userpass = new String(decodeBase64(header.substring(6).getBytes))
        userpass.split(":", 2) match {
            case Array(apiKey, apiSecret) if apiKey.nonEmpty && apiSecret.nonEmpty =>
                Some(apiKey -> apiSecret)
            case _ => None
        }
    }

    def validateAuth(request: Request[Any]): Boolean

}

class BasicAuthHandlerImpl(apiKey: String, apiSecret: String) extends BasicAuthHandler {

    def validateAuth(request: Request[Any]): Boolean = {
        getBasicAuth(request) match {
            case Some((key, secret)) => key == apiKey && secret == apiSecret
            case None => false
        }
    }
}

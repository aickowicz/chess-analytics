package controllers

import javax.inject._
import play.api.libs.json.JsValue
import play.api.libs.ws.{WSClient, WSRequest, WSResponse}
import play.api.mvc._

import scala.async.Async.{async, await}
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents, ws: WSClient) extends AbstractController(cc) {

  def index() = Action.async(
    async {
      val montlyArchives = await(fetchPlayerMontlhyArchives("aickowicz"))
      fetchGamesForMonth(montlyArchives.json)
      Ok(montlyArchives.json)
    }
  )

  def fetchPlayerMontlhyArchives(username: String) = {
    ws.url(s"https://api.chess.com/pub/player/$username/games/archives").get
  }


  def fetchGamesForMonth(archives: JsValue) = {
    for (e <- archives) println(e)
  }


  //https://api.chess.com/pub/player/{username}
}

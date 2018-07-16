package controllers

import javax.inject._
import play.api.mvc._
import org.mongodb.scala._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {

    Ok(views.html.index())
  }

  def iman = Action {
    Ok("Iman").withSession("username" -> "iman")
  }

  def echo = Action { implicit request =>
    request.session.get("username").map {
      user => Ok("Hello " + user)
    }.getOrElse {
      Unauthorized("Fuck this")
    }
  }

  def dbtest = Action {
    val mongoClient: MongoClient = MongoClient("mongodb://localhost")
    val database: MongoDatabase = mongoClient.getDatabase("ScalaPlaySample")
    val collection: MongoCollection[Document] = database.getCollection("Projects")

    Ok("succes")
  }

}

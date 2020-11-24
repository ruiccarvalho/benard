package extractor.cinemateca

import model.cinemateca.Movie
import org.joda.time.LocalDate
import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.model._

import scala.util.Try

object CinematecaScraper {
  def scrape(date: LocalDate): List[Movie] = {
    val url: String = getUrlForDate(date)

    val browser = JsoupBrowser()
    val doc = browser.get(url)

    val filmElements = doc >> elementList(".infoDetail")

    filmElements.map { filmElement =>
      val primaryTitle = (filmElement >> element(".infoTitleProg")).text
      val secondaryTitle = Try(filmElement >> element(".infoTitle")).toOption.map(_.text)
      val dateLine = (filmElement >> elementList(".infoDate")).find(_.childNodes.exists(_.isInstanceOf[TextNode])).map(_.text)
      val about = (filmElement >> elementList(".infoText")).lastOption.map(_.text)

      Movie(primaryTitle, secondaryTitle, dateLine, fromLine = None, starringLine = None, about = about)
    }
  }

  private def getUrlForDate(date: LocalDate) = {
    val formattedDate: String = date.toString("yyyy-MM-dd")

    s"http://www.cinemateca.pt/Programacao.aspx?date=${formattedDate}"
  }
}

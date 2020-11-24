import extractor.cinemateca.CinematecaScraper
import org.joda.time.LocalDate

object MainBenard extends App {
  val exampleDate = LocalDate.parse("2020-10-26")
  val result = CinematecaScraper.scrape(exampleDate)
  println("Hello, world")
  println("This a very a lousily, roughly scraped list of movies showing in Cinemateca.")
  for (movie <- result) println(movie)
}

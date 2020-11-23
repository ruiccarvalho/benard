import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._
import net.ruippeixotog.scalascraper.model._

val browser = JsoupBrowser()
val doc = browser.get("http://www.cinemateca.pt/Programacao.aspx?date=2020-11-24")

val films = doc >> elementList(".infoDetail")

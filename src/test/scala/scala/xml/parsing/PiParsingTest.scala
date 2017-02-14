package scala.xml.parsing

import org.junit.Test
import org.junit.Ignore
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import scala.xml.JUnitAssertsForXML.assertEquals

class PiParsingTest {


  import scala.io.Source.fromString
  import scala.xml.parsing.ConstructingParser.fromSource
  import scala.xml.TopScope
  private def parse(s:String) = fromSource(fromString(s), preserveWS = true).element(TopScope)
  private def parseNoWS(s:String) = fromSource(fromString(s), preserveWS = false).element(TopScope)

  @Test
  def piNoWSparse: Unit = {
    val expected = "<foo>a<?pi?>b</foo>"
    assertEquals(expected, parseNoWS("<foo>a<?pi?>b</foo>"))
  }

  @Test
  def piNoWSLiteral: Unit = {
    val expected = "<foo>a<?pi?>b</foo>"
    assertEquals(expected, <foo>a<?pi?>b</foo>)
  }

  @Test
  def piNoWSloadString: Unit = {
    val expected = "<foo>a<?pi?>b</foo>"
    assertEquals(expected, xml.XML.loadString("<foo>a<?pi?>b</foo>"))
  }

  @Test
  def piParse: Unit = {
    val expected = "<foo> a <?pi?> b </foo>"
    assertEquals(expected, parse("<foo> a <?pi?> b </foo>"))
  }

  @Test
  def piLoadString: Unit = {
    val expected = "<foo> a <?pi?> b </foo>"
    assertEquals(expected, xml.XML.loadString("<foo> a <?pi?> b </foo>"))
  }
  @Test
  def piLiteral: Unit = {
    val expected = "<foo> a <?pi?> b </foo>"
    assertEquals(expected, <foo> a <?pi?> b </foo>)
  }

}

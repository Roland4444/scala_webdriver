import java.io.{File, PrintWriter}
import java.nio.file.Files

import Message.abstractions.BinaryMessage
import Message.internal.FIAS.{FIASCodeInit, FIASResult}
import impl.JAktor
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import se.roland.Extractor
import org.openqa.selenium.Keys
class FIASService extends JAktor {
  val Ext = new Extractor()
  override def receive(message: Array[Byte]): Unit ={
    val inputMsg = BinaryMessage.restored(message).asInstanceOf[FIASCodeInit]
    val resp = new FIASResult
    resp.ID = inputMsg.ID
    try
      resp.Result = letstrygetFIAS(inputMsg.AddressGeographical)
    catch {
      case e: InterruptedException =>
        e.printStackTrace()
    }
    send(BinaryMessage.savedToBLOB(resp), inputMsg.AddressToReply)
    System.out.println(" => SEND complete")
  }


  def letstrygetFIAS(address: String): String = {
    val driver = new ChromeDriver()
    driver get ("https://dadata.ru/suggestions/#address")
    val input = driver findElementById("address-input")
    input.sendKeys(address)
    input.sendKeys(Keys.ARROW_DOWN)
    input.sendKeys(Keys.ENTER)
    Thread.sleep(2500)
    val script = new String(Files.readAllBytes(new File("js/dump.js").toPath))
    if (driver.isInstanceOf[JavascriptExecutor])
      driver.asInstanceOf[JavascriptExecutor].executeScript(script)
    val elems = driver findElementByClassName("dumpinfo")
    var Result = Ext.extractTagValue(elems.getText, "td data-ref=\"fias-codes\"")
    driver close()
    if (Result != null)
      Result
    ""
  }
}

object Service extends App {
  val la1 = new FIASService
  la1.setAddress("http://127.0.0.1:24000/")
  la1.spawn()
}

object Run extends App{
  val Ext = new Extractor
  val driver = new ChromeDriver()
  driver get ("https://dadata.ru/suggestions/#address")
  val input = driver findElementById("address-input")
  input.sendKeys("Астрахань 2я Воскресенская 38")
  input.sendKeys(Keys.ARROW_DOWN)
  input.sendKeys(Keys.ENTER)
  Thread.sleep(500)
  val script = new String(Files.readAllBytes(new File("js/dump.js").toPath))
  if (driver.isInstanceOf[JavascriptExecutor])
    driver.asInstanceOf[JavascriptExecutor].executeScript(script)
  val elems = driver findElementByClassName("dumpinfo")
  println(  Ext.extractTagValue(elems.getText, "td data-ref=\"fias-codes\""))
  driver close()
}

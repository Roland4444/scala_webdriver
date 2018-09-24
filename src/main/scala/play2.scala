import java.io.{BufferedOutputStream, File, FileOutputStream}

import org.openqa.selenium.{By, JavascriptExecutor, WebDriver}
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait
//https://google.com
import scala.runtime.Nothing$
object play2 extends App  {

  val init = new File("initial,html")
  val ended = new File("ended,html")
  val driver = new FirefoxDriver
  driver get("http://127.0.0.1:9000/test")
  val bos = new BufferedOutputStream(new FileOutputStream(init))
  val bos_end = new BufferedOutputStream(new FileOutputStream(ended))
  bos write(driver.getPageSource.getBytes)
  bos close;
  if (driver.isInstanceOf[JavascriptExecutor])
    driver.asInstanceOf[JavascriptExecutor].executeScript("  heading = document.createElement(\"h1\");\n           heading_text = document.createTextNode(\"Big Head!\");\n           heading.appendChild(heading_text);\n           document.body.appendChild(heading);")
  val element3 = driver.findElementByPartialLinkText("Link")
//  element3.click()
  println("elem3===>>>>" + element3.getText)
  val element = driver findElementByXPath("//*[text()='Big Head!']")
  println("size==>"+element.getSize)
  val link = driver findElementByXPath ("//a[@href='https://google.com']")
  link click()
  //Постановление суда апелляционной инстанции
  // Now submit the form. WebDriver will find the form for us from the element
  //element.submit()

  // Check the title of the page


  // Google's search is rendered dynamically with JavaScript.
  // Wait for the page to load, timeout after 10 seconds
  // new WebDriverWait(driver, 10).until(new ExpectedCondition[Boolean]() {
  //   override def apply(d: WebDriver): Boolean = d.getTitle.toLowerCase.startsWith("cheese!")
  // })

 // driver close  //Close the browser
}

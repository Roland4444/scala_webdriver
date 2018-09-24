import java.io.{BufferedOutputStream, File, FileOutputStream}
import org.openqa.selenium.firefox.FirefoxDriver
object play extends App{


  val init = new File("initial,html")
  val ended = new File("ended,html")
  val driver = new FirefoxDriver
  driver get("https://ras.arbitr.ru/")
  val bos = new BufferedOutputStream(new FileOutputStream(init))
  val bos_end = new BufferedOutputStream(new FileOutputStream(ended))
  bos write(driver.getPageSource.getBytes)
  bos close
  val element = driver findElementByXPath("//*[text()='Найти']")
  //val holder = driver findElementByXPath("//input[@placeholder='название, ИНН или ОГРН']")
  // Enter something to search for
  //holder sendKeys("3015011755")
  element click;

  import org.openqa.selenium.JavascriptExecutor

  if (driver.isInstanceOf[JavascriptExecutor])
    driver.asInstanceOf[JavascriptExecutor].executeScript("var z1, A1=document.querySelectorAll(\".doc-text\"); for (z1=0; z1<A1.length; z1++) { alert(A1[z1].parentNode.innerText); }")
  Thread.sleep(2000)
  bos_end write(driver.getPageSource.getBytes)
  bos_end close;
  print("\n\n\n\n\n\nawake\n\n\n\n\n\n")

  //val elem2 = driver findElementByXPath("//*[text()='Постановление суда апелляционной инстанции']")
  println(element.getText)

  val element3 = driver.findElementByPartialLinkText("Об оставлении заявления")
  println("elem3===>>>>" + element3.getText)

//Постановление суда апелляционной инстанции
  // Now submit the form. WebDriver will find the form for us from the element
  //element.submit()

  // Check the title of the page


  // Google's search is rendered dynamically with JavaScript.
  // Wait for the page to load, timeout after 10 seconds
 // new WebDriverWait(driver, 10).until(new ExpectedCondition[Boolean]() {
 //   override def apply(d: WebDriver): Boolean = d.getTitle.toLowerCase.startsWith("cheese!")
 // })

  // Should see: "cheese! - Google Search"
  println("init size :" + init.length())

  println("ended size :" + ended.length())
  //Close the browser
}

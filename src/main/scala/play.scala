import java.io.PrintWriter
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.chrome.ChromeDriver
object play extends App {
  val driver = new ChromeDriver
  driver get ("https://ras.arbitr.ru/")
  val element = driver findElementByXPath ("//*[text()='Найти']")
  element click;
  Thread sleep(5000)
  if (driver.isInstanceOf[JavascriptExecutor])
    driver.asInstanceOf[JavascriptExecutor].executeScript("var z1, A1=document.querySelectorAll(\".doc-text\"); for (z1=0; z1<A1.length; z1++) {\n  var div = document.createElement('a');\n  div.className = \"info\";\n  div.href = A1[z1].querySelectorAll(\"A\")[0].href;\n  div.innerText = A1[z1].parentNode.innerText;\n  document.body.insertBefore(div, document.body.firstChild);\n}")
  val elems = driver findElementsByClassName("info")
  val outs = new PrintWriter("out")
  for (i<-0 to  elems.size()-1){
    val href = elems.get(i).getAttribute("href")
    val desc = elems.get(i).getText
    outs.println(href)
    outs.println(desc)
    outs.println("\n\n")
  }
  outs.close
  //driver close
}

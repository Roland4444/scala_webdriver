import java.io.PrintWriter

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.JavascriptExecutor
import play.driver
object play extends App {

  val option = new ChromeOptions
  option.addArguments("--proxy-server=http://" + "217.160.0.175 ")
  val driver = new ChromeDriver(option)
  driver get ("https://ras.arbitr.ru/")
  val input = driver findElementsByClassName("g-ph")
  val type_ = driver findElementByClassName("g-ph")
  val typeEnter = input.get(1).sendKeys("о несостоятельности (банкротстве) организаций и граждан")
  val inputINN = input.get(3).sendKeys("3015011755")
  val element = driver findElementByXPath ("//*[text()='Найти']")
  element click;
  Thread sleep(5000)
  if (driver.isInstanceOf[JavascriptExecutor]){}
    driver.asInstanceOf[JavascriptExecutor].executeScript("var z1, A1=document.querySelectorAll(\".doc-text\"); for (z1=0; z1<A1.length; z1++) {\n  var div = document.createElement('a');\n  div.className = \"info\";\n  div.href = A1[z1].querySelectorAll(\"A\")[0].href;\n  div.innerText = A1[z1].parentNode.innerText;\n  document.body.insertBefore(div, document.body.firstChild);\n}")
  val elems = driver findElementsByClassName("info")
  val outs = new PrintWriter("out")
  for (i<-0 to  elems.size-1){
    val href = elems.get(i).getAttribute("href")
    val desc = elems.get(i).getText
    outs.println(i)
    outs.println(href)
    outs.println(desc)
    outs.println("\n\n")
  }
  outs.close
  //driver close
}



//https://fias.nalog.ru/ExtendedSearchPage.aspx


object play3 extends App {
  val driver = new ChromeDriver()
  driver get ("https://fias.nalog.ru/ExtendedSearchPage.aspx")
  val input = driver.findElementById("ctl00_contentPlaceHolder_kladrAddressObjectControl_addressObjectMultiViewControl_addressObjectMOControl_areaMORadComboBox_Arrow")
  val element = driver findElementByXPath ("//*[text()='Административно-территориальное']")
  element click()
  Thread.sleep(2000)
  val element2 = driver findElementById("ctl00_contentPlaceHolder_kladrAddressObjectControl_addressObjectMultiViewControl_addressObjectControl_regionRadComboBox_Arrow")
  element2 click()
  Thread.sleep(2000)
  val element3 = driver findElementByPartialLinkText("Астраханская область")
  element3 click()
}
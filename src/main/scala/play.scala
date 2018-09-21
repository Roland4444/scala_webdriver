object play extends App{

  import org.openqa.selenium.By
  import org.openqa.selenium.WebDriver
  import org.openqa.selenium.firefox.FirefoxDriver
  import org.openqa.selenium.support.ui.ExpectedCondition
  import org.openqa.selenium.support.ui.WebDriverWait

  val driver = new FirefoxDriver
  driver get("https://ras.arbitr.ru/")
  val element = driver findElementByXPath("//*[text()='Найти']")
  val holder = driver findElementByXPath("//input[@placeholder='название, ИНН или ОГРН']")
  // Enter something to search for
  holder sendKeys("3015011755")
  element click

  // Now submit the form. WebDriver will find the form for us from the element
  //element.submit()

  // Check the title of the page
  println("Page title is: " + driver.getTitle)

  // Google's search is rendered dynamically with JavaScript.
  // Wait for the page to load, timeout after 10 seconds
  new WebDriverWait(driver, 10).until(new ExpectedCondition[Boolean]() {
    override def apply(d: WebDriver): Boolean = d.getTitle.toLowerCase.startsWith("cheese!")
  })

  // Should see: "cheese! - Google Search"
  System.out.println("Page title is: " + driver.getTitle)

  //Close the browser
}

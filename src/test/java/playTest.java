import org.junit.Test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.disappears;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class playTest {
    @Test
    public void user_can_search_everything_in_google() {
        open("http://google.com/ncr");

    }

}
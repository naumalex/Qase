package tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class LoginTests extends BaseTest{
    @Test
    public void positiveLoginTest() {
        loginPage.login(DEFAULT_EMAIL, DEFAULT_PASSWORD);
        homePage.waitForPageLoaded();
        $(homePage.NAVIGATION_BAR_ITEM_PROJECTS_LOCATOR).should(Condition.visible);
    }
}

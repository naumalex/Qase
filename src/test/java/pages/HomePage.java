package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage{
    public final By NAVIGATION_BAR_ITEM_PROJECTS_LOCATOR =
            By.xpath("//a[text()='Projects']");

    @Override
    public void waitForPageLoaded() {
        $(NAVIGATION_BAR_ITEM_PROJECTS_LOCATOR).should(Condition.visible);
    }

    public SelenideElement getAlert() {
        return $("div[role='alert']");
    }
}



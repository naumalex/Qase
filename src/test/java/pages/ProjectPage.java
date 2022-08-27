package pages;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class ProjectPage extends HomePage {
    private final String NEW_TEST_CASE_BUTTON_SELECTOR =
            "#create-case-button";
    private final String DEFECTS_NAVIGATION_MENU_ITEM = "a[title = 'Defects']";

    @Override
    public void waitForPageLoaded() {
        $(NEW_TEST_CASE_BUTTON_SELECTOR)
                .should(Condition.visible, Duration.ofSeconds(30))
                .should(Condition.enabled, Duration.ofSeconds(30));
    }

    public void clickCreateTestCaseButton() {
        $(NEW_TEST_CASE_BUTTON_SELECTOR).click();
    }

    public void clickDefects() {
        $(DEFECTS_NAVIGATION_MENU_ITEM).scrollTo().click();
    }
}

package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DefectsPage extends HomePage {

    private final String xpathExpression =
            "//div[@id='application-content']//a[text() = 'Create new defect']";

    @Override
    public void waitForPageLoaded() {
       $(By.xpath(xpathExpression)).should(Condition.visible, Condition.enabled);
    }

    public void clickCreateNewDefect() {
        $(By.xpath(xpathExpression)).click();
    }
}

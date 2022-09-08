package elements.comboboxes;

import com.codeborne.selenide.SelenideElement;
import elements.BaseElement;
import enums.common.BaseEnum;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public abstract class BaseCombobox extends BaseElement {

    public BaseCombobox(String label) {
        super(label);
    }

    public void selectByVisibleText(String visibleText) {
        if (visibleText == null)
            return;
        expandListOfOptions();
        selectOption(visibleText);
    }

    public  void selectByEnumValue(BaseEnum enumValue) {
        if (enumValue == null)
            return;
        expandListOfOptions();
        selectOption(enumValue.getName());
    }

    protected abstract String getComboboxItemXpathExpression();

    protected String getComboboxButtonXpathExpression() {
        return "//label[text() = '%s']/following-sibling::div";
    }

    private void expandListOfOptions() {
        $(By.xpath(String.format(getComboboxButtonXpathExpression(), label)))
                .scrollTo().click();
    }

    private void selectOption(String option) {
        SelenideElement comboboxElement = $(By.xpath(
                String.format(getComboboxItemXpathExpression(), option)));
        comboboxElement.scrollTo().click();
    }
}

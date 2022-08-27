package pages;

import com.codeborne.selenide.Condition;
import elements.comboboxes.ReactCombobox;
import elements.comboboxes.ReactComboboxWithHeaderLabel;
import elements.inputs.Input;
import elements.inputs.MultiLineInput;
import models.Defect;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NewDefectPage extends BasePage {
    private final String CREATE_DEFECT_BUTTON_XPATH_EXPRESSION =
            "//button[text()='Create defect']";
    @Override
    public void waitForPageLoaded() {
        $(By.xpath(CREATE_DEFECT_BUTTON_XPATH_EXPRESSION)).should(Condition.visible,
                Condition.enabled);
    }

    public void fillForm(Defect inputDefect) {
        new Input("Defect title")
                .setValue(inputDefect.getDefectTitle());
        new MultiLineInput("Actual result")
                .setValue(inputDefect.getActualResult());
        new ReactCombobox("Milestone")
                .selectByVisibleText(inputDefect.getMilestone());
        new ReactCombobox("Severity")
                .selectByEnumValue(inputDefect.getSeverity());
        new ReactCombobox("Assignee")
                .selectByVisibleText(inputDefect.getAssignee());
        new ReactComboboxWithHeaderLabel("Tags")
                .selectByVisibleText(inputDefect.getTags());
    }

    public void clickCreateDefect() {
        $(By.xpath(CREATE_DEFECT_BUTTON_XPATH_EXPRESSION)).click();
    }
}

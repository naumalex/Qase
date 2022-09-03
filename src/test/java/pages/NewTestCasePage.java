package pages;

import com.codeborne.selenide.Condition;
import elements.comboboxes.Combobox;
import elements.comboboxes.ReactCombobox;
import elements.inputs.Input;
import elements.inputs.MultiLineInput;
import models.TestCase;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NewTestCasePage extends BasePage {
    private final By PAGE_HEADER_LOCATOR =
            By.xpath("//h1[text()='Create test case']");

    @Override
    public void waitForPageLoaded() {
        $(PAGE_HEADER_LOCATOR).should(Condition.visible);
    }

    public void fillForm(TestCase inputTestCase) {
        new Input("Title")
                .setValue(inputTestCase.getTitle());
        new MultiLineInput("Description")
                .setValue(inputTestCase.getDescription());
        new Combobox("Status")
                .selectByEnumValue(inputTestCase.getStatus());
        new Combobox("Suite")
                .selectByVisibleText(inputTestCase.getSuite());
        new Combobox("Severity")
                .selectByEnumValue(inputTestCase.getSeverity());
        new Combobox("Priority")
              .selectByEnumValue(inputTestCase.getPriority());
        new Combobox("Type")
                .selectByEnumValue(inputTestCase.getType());
        new Combobox("Layer")
                .selectByEnumValue(inputTestCase.getLayer());
        new Combobox("Is flaky")
                .selectByEnumValue(inputTestCase.getIsFlaky());
        new ReactCombobox("Milestone")
                .selectByVisibleText(inputTestCase.getMilestone());
        new Combobox("Behaviour")
                .selectByEnumValue(inputTestCase.getBehavior());
        new Combobox("Automation status")
                .selectByEnumValue(inputTestCase.getAutomationStatus());
        new MultiLineInput("Pre-conditions")
                .setValue(inputTestCase.getPreConditions());
        new MultiLineInput("Post-conditions")
                .setValue(inputTestCase.getPostConditions());
    }

    public void clickSave() {
        final String SAVE_BUTTON_SELECTOR = "#save-case";
        $(SAVE_BUTTON_SELECTOR).scrollTo().click();
    }
}

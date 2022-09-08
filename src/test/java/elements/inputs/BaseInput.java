package elements.inputs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.BaseElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public abstract class BaseInput extends BaseElement {

    public BaseInput(String label) {
        super(label);
    }

    abstract By getInputLocator();

    public void setValue(String value) {
        if (value == null) {
            return;
        }
        SelenideElement inputElement = $(getInputLocator());
         inputElement.scrollTo()
                 .should(Condition.enabled).setValue(value);
    }
}

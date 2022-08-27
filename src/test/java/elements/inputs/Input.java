package elements.inputs;
import org.openqa.selenium.By;

public class Input extends BaseInput {

    public Input(String label) {
        super(label);
    }

    @Override
    By getInputLocator() {
        final String INPUT_XPATH_EXPRESSION =
                "//label[text()='%s']/following-sibling::div/input";
        return By.xpath(String.format(INPUT_XPATH_EXPRESSION, label));
    }
}

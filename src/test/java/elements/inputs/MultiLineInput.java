package elements.inputs;
import org.openqa.selenium.By;

public class MultiLineInput extends BaseInput {

    public MultiLineInput(String label) {
        super(label);
    }

    @Override
    By getInputLocator() {
        final String INPUT_XPATH_EXPRESSION =
                "//label[text()='%s']/following-sibling::div//" +
                        "div[@class ='ProseMirror toastui-editor-contents']";
        return By.xpath(String.format(INPUT_XPATH_EXPRESSION, label));
    }
}

package elements.comboboxes;
public class ReactComboboxWithHeaderLabel extends ReactCombobox {

    public ReactComboboxWithHeaderLabel(String label) {
        super(label);
    }

    @Override
    protected String getComboboxButtonXpathExpression() {
        return "//div[text() = '%s']/following-sibling::div[1]";
    }
}

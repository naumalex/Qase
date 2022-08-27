package elements.comboboxes;

public class ReactCombobox extends BaseCombobox {

    public ReactCombobox(String label) {
        super(label);
    }

    @Override
    protected String getComboboxItemXpathExpression() {
        return "//div[starts-with(@id,'react-select') and text() = '%s']";
    }
}

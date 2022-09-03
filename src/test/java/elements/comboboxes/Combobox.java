package elements.comboboxes;

public class Combobox extends BaseCombobox {

    public Combobox(String label) {
        super(label);
    }

    @Override
    protected String getComboboxItemXpathExpression() {
        return "//div[text()= '%s' and contains(@class, 'DJXdnf')]";
    }
}

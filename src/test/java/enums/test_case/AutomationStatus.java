package enums.test_case;

import enums.common.BaseEnum;

import java.util.Arrays;

public enum AutomationStatus implements BaseEnum {
    NOT_AUTOMATED("Not automated"), TO_BE_AUTOMATED("To be automated"),
    AUTOMATED("Automated");

    private final String name;

    AutomationStatus(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public static AutomationStatus fromString(String stringValue) {
        return  Arrays.stream(AutomationStatus.values())
                .filter(p -> p.name.equals(stringValue))
                .findFirst().orElse(null);
    }
}

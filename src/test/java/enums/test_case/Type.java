package enums.test_case;

import enums.common.BaseEnum;

import java.util.Arrays;

public enum Type implements BaseEnum {
    OTHER("Other"), FUNCTIONAL("Functional"),
    SMOKE("Smoke"), REGRESSION("Regression"),
    SECURITY("Security"), USABILITY("Usability"),
    PERFORMANCE("Performance"), ACCEPTANCE("Acceptance"),
    COMPATIBILITY("Compatibility"), INTEGRATION("Integration"),
    EXPLORATORY("Exploratory");

    private final String name;

    Type(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public static Type fromString(String stringValue) {
        return  Arrays.stream(Type.values())
                .filter(p -> p.name.equals(stringValue))
                .findFirst().orElse(null);
    }
}

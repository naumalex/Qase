package enums.test_case;

import enums.common.BaseEnum;

import java.util.Arrays;

public enum Priority implements BaseEnum {
    NOT_SET("Not set"), HIGH("High"),
    MEDIUM("Medium"), LOW("low");

    private final String name;

    Priority(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public static Priority fromString(String stringValue) {
        return  Arrays.stream(Priority.values())
                .filter(p -> p.name.equals(stringValue))
                .findFirst().orElse(null);
    }
}

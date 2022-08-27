package enums.test_case;

import enums.common.BaseEnum;

import java.util.Arrays;

public enum Status implements BaseEnum {
    ACTUAL("Actual"), DRAFT("Draft"),
    DEPRECATED("Deprecated");

    private final String name;

    Status(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public static Status fromString(String stringValue) {
        return  Arrays.stream(Status.values())
                .filter(p -> p.name.equals(stringValue))
                .findFirst().orElse(null);
    }
}

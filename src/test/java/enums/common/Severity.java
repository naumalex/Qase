package enums.common;

import java.util.Arrays;

public enum Severity implements BaseEnum {
    NOT_SET("Not set"), BLOCKER("Blocker"),
    CRITICAL("Critical"), MAJOR("Major"),
    NORMAL("Normal"), MINOR("Minor");

    private final String name;

    Severity(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public static Severity fromString(String stringValue) {
        return  Arrays.stream(Severity.values())
                .filter(p -> p.name.equals(stringValue))
                .findFirst().orElse(null);
    }
}

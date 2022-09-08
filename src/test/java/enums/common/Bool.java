package enums.common;

import java.util.Arrays;

public enum Bool implements BaseEnum {
    YES("Yes"), NO("No");

    private final String name;

    Bool(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public static Bool fromString(String stringValue) {
        return  Arrays.stream(Bool.values())
                .filter(p -> p.name.equals(stringValue))
                .findFirst().orElse(null);
    }
}

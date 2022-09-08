package enums.test_case;

import enums.common.BaseEnum;
import java.util.Arrays;

public enum Behavior implements BaseEnum {
    NOT_SET("Not set"), POSITIVE("Positive"),
    NEGATIVE("Negative"), DESTRUCTIVE("Destructive");

    private  final String name;

    Behavior(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public static Behavior fromString(String stringValue) {
        return  Arrays.stream(Behavior.values())
                .filter(p -> p.name.equals(stringValue))
                .findFirst().orElse(null);
    }
}

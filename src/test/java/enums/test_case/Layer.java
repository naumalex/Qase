package enums.test_case;

import enums.common.BaseEnum;

import java.util.Arrays;

public enum Layer implements BaseEnum {
    NOT_SET("Not set"), E2E("E2E"),
    API("API"), UNIT("Unit");

    private final String name;

    Layer(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public static Layer fromString(String stringValue) {
        return  Arrays.stream(Layer.values())
                .filter(p -> p.name.equals(stringValue))
                .findFirst().orElse(null);
    }
}

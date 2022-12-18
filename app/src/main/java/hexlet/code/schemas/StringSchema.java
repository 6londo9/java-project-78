package hexlet.code.schemas;

import lombok.Getter;

import java.util.Objects;

@Getter
public final class StringSchema extends BaseSchema {

    public StringSchema() {

    }

    @Override
    public StringSchema required() {
        addCheck("required", value -> value != null && ((value instanceof String) && !value.equals("")));
        return this;
    }

    public StringSchema minLength(int length) {
        addCheck("minLength", value -> String.valueOf(nullToBlank(value)).length() >= length);
        return this;
    }

    public StringSchema contains(String str) {
        addCheck("contains", value -> String.valueOf(value).contains(str));
        return this;
    }


    private Object nullToBlank(Object value) {
        return Objects.requireNonNullElse(value, "");
    }
}

package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema() {

    }

    public StringSchema required() {
        addCheck("required", value -> (value instanceof String) && !((String) value).isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        addCheck("minLength", value -> ((String) value).length() >= length);
        return this;
    }

    public StringSchema contains(String str) {
        addCheck("contains", value -> String.valueOf(value).contains(str));
        return this;
    }
}

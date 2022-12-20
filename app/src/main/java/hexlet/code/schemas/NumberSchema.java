package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        addCheck("required", value -> value instanceof Integer);
        return this;
    }

    public NumberSchema range(Integer begin, Integer end) {
        addCheck("range", value -> ((int) value >= begin
                && (int) value <= end));
        return this;
    }

    public NumberSchema positive() {
        addCheck("positive", value -> value == null || (value instanceof Integer) && (Integer) value > 0);
        return this;
    }
}

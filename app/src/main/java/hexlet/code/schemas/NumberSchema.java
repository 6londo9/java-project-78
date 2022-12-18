package hexlet.code.schemas;

import lombok.Getter;

@Getter
public final class NumberSchema extends BaseSchema {

    public NumberSchema() {

    }

    @Override
    public NumberSchema required() {
        addCheck("required", value -> (value instanceof Integer)
                && (int) value > 0);
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

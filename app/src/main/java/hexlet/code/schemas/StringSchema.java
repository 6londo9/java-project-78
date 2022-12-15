package hexlet.code.schemas;

import hexlet.code.utils.ValidatorUtils;
import lombok.Getter;

@Getter
public final class StringSchema extends BaseSchema {

    private int minLength = 0;
    private String ifContains = null;
    private boolean required = false;

    public StringSchema(ValidatorUtils utils) {
        super(utils);
    }

    public StringSchema required() {
        this.required = true;
        return this;
    }

    public void minLength(int length) {
        this.minLength = length;
    }

    public StringSchema contains(Object contains) {
        this.ifContains = String.valueOf(contains);
        return this;
    }
}

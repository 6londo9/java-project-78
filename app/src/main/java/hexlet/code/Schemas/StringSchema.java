package hexlet.code.Schemas;

import hexlet.code.Utils.ValidatorUtils;
import lombok.Getter;

@Getter
public class StringSchema extends BaseSchema {

    private int minLength = 0;
    private String ifContains = null;

    public StringSchema(ValidatorUtils utils) {
        super(utils);
    }

    public void minLength(int length) {
        this.minLength = length;
    }

    public StringSchema contains(Object contains) {
        this.ifContains = String.valueOf(contains);
        return this;
    }
}

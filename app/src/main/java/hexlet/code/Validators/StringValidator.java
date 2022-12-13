package hexlet.code.Validators;

import hexlet.code.Utils.StringValidatorUtils;
import hexlet.code.Schemas.StringSchema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StringValidator implements StringSchema {

    private Object schema = null;
    private boolean required = false;
    private int minLength = 0;
    private String ifContains = null;

    @Override
    public boolean isValid(Object newSchema) {
        StringValidatorUtils utils = new StringValidatorUtils();
        this.schema = newSchema;
        return utils.isValid(this);
    }

    @Override
    public void required() {
        this.required = true;
    }

    @Override
    public void minLength(int length) {
        this.minLength = length;
    }

    @Override
    public StringValidator contains(Object contains) {
        this.ifContains = String.valueOf(contains);
        return this;
    }
}

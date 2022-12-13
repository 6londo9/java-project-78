package hexlet.code.validators;

import hexlet.code.Utils.StringValidatorUtils;
import hexlet.code.schemas.StringSchema;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StringValidator implements StringSchema {

    private Object schema = null;
    private boolean required = false;
    private int minLength = 0;
    private String ifContains = null;

    @Override
    public boolean isValid(Object newSchema) {
        StringValidatorUtils utils = new StringValidatorUtils();
        if (utils.isNewSchema(this.schema, newSchema)) {
            this.schema = newSchema;
        }
        return utils.isValidUtils(this.schema, this.required, this.minLength, this.ifContains);
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

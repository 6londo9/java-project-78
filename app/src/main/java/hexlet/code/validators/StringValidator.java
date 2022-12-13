package hexlet.code.validators;

import hexlet.code.Utils.StringValidatorUtils;
import hexlet.code.schemas.StringSchema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StringValidator implements StringSchema {

    private Object schema = null;
    private boolean isValid = true;
    private boolean required = false;
    private int minLength = 0;
    private String ifContains = null;
    private StringValidatorUtils utils;
    @Override
    public boolean isValid(Object schema) {
        utils = new StringValidatorUtils();
        if (utils.isNewSchema(this.schema, schema)) {
            this.schema = schema;
            this.isValid = true;
        }
        return this.isValid = utils.isValidUtils(schema, this.required, this.minLength, this.ifContains);
    }

    @Override
    public void required() {
        this.required = true;
    }

    @Override
    public void minLength(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public StringValidator contains(Object schema) {
        this.ifContains = String.valueOf(schema);
        return this;
    }
}

package hexlet.code;


import hexlet.code.Utils.ValidatorUtils;
import lombok.Getter;

@Getter
public class BaseSchema {
    private Object schema = null;
    private ValidatorUtils validator;
    private boolean required = false;
    BaseSchema(ValidatorUtils utils) {
        this.validator = utils;
    }
    public boolean isValid(Object newSchema) {
        this.schema = newSchema;
        return validator.isValid(this);
    }
    public BaseSchema required() {
        this.required = true;
        return this;
    }
}

package hexlet.code.schemas;


import hexlet.code.utils.ValidatorUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
public class BaseSchema {
    private Object schema = null;
    private final ValidatorUtils validator;
    @Setter
    private boolean required = false;
    BaseSchema(ValidatorUtils utils) {
        this.validator = utils;
    }
    public final boolean isValid(Object newSchema) {
        this.schema = newSchema;
        return validator.isValid(this);
    }
//    public BaseSchema required() {
//        this.required = true;
//        return this;
//    }
}

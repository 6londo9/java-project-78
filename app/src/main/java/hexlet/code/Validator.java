package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import hexlet.code.utils.MapValidatorUtils;
import hexlet.code.utils.NumberValidatorUtils;
import hexlet.code.utils.StringValidatorUtils;

public class Validator {

    public StringSchema string() {
        return new StringSchema(new StringValidatorUtils());
    }

    public NumberSchema number() {
        return new NumberSchema(new NumberValidatorUtils());
    }

    public MapSchema map() {
        return new MapSchema(new MapValidatorUtils());
    }
}

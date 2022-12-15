package hexlet.code;

import hexlet.code.Utils.MapValidatorUtils;
import hexlet.code.Utils.NumberValidatorUtils;
import hexlet.code.Utils.StringValidatorUtils;

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

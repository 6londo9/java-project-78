package hexlet.code;

import hexlet.code.Validators.NumberValidator;
import hexlet.code.Validators.StringValidator;

public class Validator {

    public StringValidator string() {
        return new StringValidator();
    }

    public NumberValidator number() {
        return new NumberValidator();
    }
}

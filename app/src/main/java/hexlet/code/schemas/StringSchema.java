package hexlet.code.schemas;

import hexlet.code.validators.StringValidator;

public interface StringSchema {
    boolean isValid(Object schema);

    void required();

    void minLength(int minLength);

    StringValidator contains(Object schema);
}

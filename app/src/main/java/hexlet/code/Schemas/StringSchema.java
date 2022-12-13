package hexlet.code.Schemas;

import hexlet.code.Validators.StringValidator;

public interface StringSchema extends BaseSchema {

    void minLength(int minLength);

    StringValidator contains(Object schema);
}

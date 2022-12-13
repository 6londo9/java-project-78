package hexlet.code.Schemas;

import hexlet.code.Validators.NumberValidator;

public interface NumberSchema extends BaseSchema {

    void range(Integer begin, Integer end);

    NumberValidator positive();
}

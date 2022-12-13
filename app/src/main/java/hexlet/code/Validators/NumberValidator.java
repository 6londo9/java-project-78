package hexlet.code.Validators;

import hexlet.code.Utils.NumberValidatorUtils;
import hexlet.code.Schemas.NumberSchema;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class NumberValidator implements NumberSchema {
    private Object number = null;
    private boolean required = false;
    private List<Integer> range;
    private boolean positive = false;

    @Override
    public boolean isValid(Object newNumber) {
        NumberValidatorUtils utils = new NumberValidatorUtils();
        this.number = newNumber;
        return utils.isValid(this);
    }

    @Override
    public void required() {
        this.required = true;
    }

    @Override
    public void range(Integer begin, Integer end) {
        range = List.of(begin, end);
    }

    @Override
    public NumberValidator positive() {
        this.positive = true;
        return this;
    }
}

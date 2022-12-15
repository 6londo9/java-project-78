package hexlet.code.schemas;

import hexlet.code.utils.ValidatorUtils;
import lombok.Getter;

import java.util.List;

@Getter
public class NumberSchema extends BaseSchema {

    private boolean required = false;
    private List<Integer> range;
    private boolean positive = false;

    public NumberSchema(ValidatorUtils utils) {
        super(utils);
    }

    public NumberSchema required() {
        this.required = true;
        return this;
    }

    public void range(Integer begin, Integer end) {
        this.range = List.of(begin, end);
    }

    public NumberSchema positive() {
        this.positive = true;
        return this;
    }
}

package hexlet.code.utils;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.NumberSchema;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public final class NumberValidatorUtils implements ValidatorUtils {

    @Override
    public boolean isValid(BaseSchema schema) {
        NumberSchema validator = (NumberSchema) schema;
        return required(validator.getSchema(), validator.isRequired())
                && isPositive(validator.getSchema(), validator.isPositive())
                && isInRange(validator.getSchema(), validator.getRange());
    }

    private boolean required(Object number, boolean isRequired) {
        if (isRequired) {
            return (number instanceof Integer) && (Integer) number > 0;
        } else {
            return number == null || (number instanceof Integer);
        }
    }

    private boolean isPositive(Object number, boolean isPositive) {
        if (isPositive) {
            return number == null || (Integer) number > 0;
        }
        return true;
    }

    private boolean isInRange(Object number, List<Integer> range) {
        if (range == null) {
            return true;
        }
        return number != null && ((Integer) number >= range.get(0) && (Integer) number <= range.get(1));
    }
}

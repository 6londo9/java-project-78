package hexlet.code.Utils;

import hexlet.code.Validators.NumberValidator;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class NumberValidatorUtils {

    public boolean isValid(NumberValidator validator) {
        return required(validator.getNumber(), validator.isRequired())
                && isPositive(validator.getNumber(), validator.isPositive())
                && isInRange(validator.getNumber(), validator.getRange());
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

package hexlet.code.Utils;

import hexlet.code.Schemas.BaseSchema;
import hexlet.code.Schemas.StringSchema;
import lombok.NoArgsConstructor;

import java.util.Objects;
@NoArgsConstructor
public class StringValidatorUtils implements ValidatorUtils {

    @Override
    public boolean isValid(BaseSchema schema) {
        StringSchema validator = (StringSchema) schema;
        return required(validator.getSchema(), validator.isRequired())
                && isContains(validator.getSchema(), validator.getIfContains())
                && isMoreThanMinLength(validator.getSchema(), validator.getMinLength());
    }

    private boolean isContains(Object schema, String contains) {
        if (contains != null) {
            return String.valueOf(schema).contains(contains);
        }
        return true;
    }

    private boolean isMoreThanMinLength(Object schema, int minLength) {
        return String.valueOf(nullToBlank(schema)).length() >= minLength;
    }

    private boolean required(Object schema, boolean isRequired) {
        if (isRequired) {
            return isRequired(schema);
        } else {
            return isNotRequired(schema);
        }
    }

    private boolean isNotRequired(Object schema) {
        return schema == null || (schema instanceof String || schema.equals(""));
    }

    private boolean isRequired(Object schema) {
        return schema != null && ((schema instanceof String) && !schema.equals(""));
    }

    private Object nullToBlank(Object value) {
        return Objects.requireNonNullElse(value, "");
    }
}

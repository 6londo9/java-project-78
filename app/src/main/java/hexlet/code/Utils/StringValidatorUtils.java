package hexlet.code.Utils;

import lombok.NoArgsConstructor;

import java.util.Objects;
@NoArgsConstructor
public class StringValidatorUtils {

    public boolean isNewSchema(Object firstSchema, Object secondSchema) {
        if (firstSchema == null) {
            return secondSchema != null;
        }
        Object oldSchema = nullToBlank(firstSchema);
        Object newSchema = nullToBlank(secondSchema);
        return !(String.valueOf(oldSchema).equals(String.valueOf(newSchema)));
    }

    public boolean isValidUtils(Object schema, boolean isRequired, int minLength, String contains) {
        return required(schema, isRequired)
                && isContains(schema, contains)
                && isMoreThanMinLength(schema, minLength);
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

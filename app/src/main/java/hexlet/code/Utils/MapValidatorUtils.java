package hexlet.code.Utils;

import hexlet.code.Schemas.BaseSchema;
import hexlet.code.Schemas.MapSchema;

import java.util.Map;

public class MapValidatorUtils implements ValidatorUtils {
    @Override
    public boolean isValid(BaseSchema schema) {
        MapSchema validator = (MapSchema) schema;
        return required(validator.getSchema(), validator.isRequired())
                && isRequiredSize(validator.getSchema(), validator.getSizeof());
    }

    private boolean required(Object map, boolean isRequired) {
        if (isRequired) {
            return map instanceof Map;
        } else {
            return map == null || (map instanceof Map);
        }
    }

    private boolean isRequiredSize(Object map, int size) {
        if (size == 0) {
            return true;
        } else {
            if (map == null) {
                return false;
            } else {
                Map<Object, Object> objectMap = (Map<Object, Object>) map;
                return objectMap.size() >= size;
            }
        }
    }
}

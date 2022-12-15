package hexlet.code.utils;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;

import java.util.Map;

public final class MapValidatorUtils implements ValidatorUtils {
    @Override
    public boolean isValid(BaseSchema schema) {
        MapSchema validator = (MapSchema) schema;
        return required(validator.getSchema(), validator.isRequired())
                && isRequiredSize(validator.getSchema(), validator.getSizeof())
                && isShapeTrue(validator.getSchema(), validator.getMap());
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
            }
            Map<String, Object> objectMap = (Map<String, Object>) map;
            return objectMap.size() >= size;
        }
    }

    private boolean isShapeTrue(Object map, Map<String, BaseSchema> schemas) {
        if (schemas == null) {
            return true;
        }
        Map<String, Object> objectMap = (Map<String, Object>) map;
        for (Map.Entry<String, BaseSchema> entry : schemas.entrySet()) {
            BaseSchema validator = entry.getValue();
            Object key = entry.getKey();
            if (!validator.isValid(objectMap.get(key))) {
                return false;
            }
        }
        return true;
    }
}

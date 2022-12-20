package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    public MapSchema required() {
        addCheck("required", value -> value instanceof Map);
        return this;
    }

    public MapSchema sizeof(int size) {
        addCheck("sizeof", value -> ((Map<String, Object>) value).size() >= size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addCheck("shape", value -> {
            for (Map.Entry<String, Object> entry : ((Map<String, Object>) value).entrySet()) {
                BaseSchema validator = schemas.get(entry.getKey());
                if (!validator.isValid(entry.getValue())) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }
}

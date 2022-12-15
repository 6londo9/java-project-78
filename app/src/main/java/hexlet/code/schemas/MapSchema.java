package hexlet.code.schemas;


import hexlet.code.utils.ValidatorUtils;
import lombok.Getter;

import java.util.Map;

@Getter
public class MapSchema extends BaseSchema {

    private int sizeof = 0;
    private boolean required = false;
    private Map<String, BaseSchema> map = null;

    public MapSchema(ValidatorUtils utils) {
        super(utils);
    }

    public MapSchema required() {
        this.required = true;
        return this;
    }

    public void sizeof(int size) {
        this.sizeof = size;
    }

    public void shape(Map<String, BaseSchema> schema) {
        this.map = schema;
    }
}

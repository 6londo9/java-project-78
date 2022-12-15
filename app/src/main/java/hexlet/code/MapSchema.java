package hexlet.code;


import hexlet.code.Utils.ValidatorUtils;
import lombok.Getter;

import java.util.Map;

@Getter
public class MapSchema extends BaseSchema {

    private int sizeof = 0;
    private Map<Object, BaseSchema> map = null;

    public MapSchema(ValidatorUtils utils) {
        super(utils);
    }

    public void sizeof(int size) {
        this.sizeof = size;
    }

    public void shape(Map<Object, BaseSchema> schema) {
        this.map = schema;
    }
}

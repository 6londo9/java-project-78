package hexlet.code.Schemas;


import hexlet.code.Utils.ValidatorUtils;
import lombok.Getter;

@Getter
public class MapSchema extends BaseSchema {

    private int sizeof = 0;

    public MapSchema(ValidatorUtils utils) {
        super(utils);
    }

    public void sizeof(int size) {
        this.sizeof = size;
    }
}

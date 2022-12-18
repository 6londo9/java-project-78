package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    private final int positiveNumber = 4;
    private final int negativeNumber = -100;
    private final int startOfRange = 3;
    private final int endOfRange = 11;
    private final int inTheRange = 5;
    private final int outOfRange = 12;
    @Test
    void testStringValidator() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertThat(schema.isValid("")).isTrue();
        assertThat(schema.isValid("valid")).isTrue();

        schema.required();
        assertThat(schema.isValid("")).isFalse();

        schema.minLength(positiveNumber);
        assertThat(schema.isValid("true")).isTrue();
        assertThat(schema.isValid("no")).isFalse();

        assertThat(schema.contains("what").isValid("what does the fox say")).isTrue();
        assertThat(schema.contains("whale").isValid("what does the fox say")).isFalse();
        assertThat(schema.contains("wha").isValid("what does the fox say")).isTrue();
    }

    @Test
    void testNumberValidator() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid(0)).isTrue();

        assertThat(schema.positive().isValid(null)).isTrue();
        assertThat(schema.positive().isValid(negativeNumber)).isFalse();
        assertThat(schema.positive().isValid(0)).isFalse();

        schema.required();

        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid("0")).isFalse();
        assertThat(schema.isValid(negativeNumber)).isFalse();
        assertThat(schema.isValid(positiveNumber)).isTrue();

        schema.range(startOfRange, endOfRange);

        assertThat(schema.isValid(startOfRange)).isTrue();
        assertThat(schema.isValid(inTheRange)).isTrue();
        assertThat(schema.isValid(0)).isFalse();
        assertThat(schema.isValid(outOfRange)).isFalse();
    }

    @Test
    void testMapValidator() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid(new HashMap<>())).isTrue();

        schema.required();

        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(0)).isFalse();
        Map<String, String> data = new HashMap<>();
        assertThat(schema.isValid(data)).isTrue();
        data.put("map", "schema");
        assertThat(schema.isValid(data)).isTrue();

        schema.sizeof(2);

        assertThat(schema.isValid(data)).isFalse();
        data.put("the answer", "is true");
        assertThat(schema.isValid(data)).isTrue();
    }

    @Test
    void testShape() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", positiveNumber);
        assertThat(schema.isValid(human1)).isTrue();

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertThat(schema.isValid(human2)).isTrue();

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertThat(schema.isValid(human3)).isFalse();

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", negativeNumber);
        assertThat(schema.isValid(human4)).isFalse();
    }
}

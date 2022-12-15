package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    private static Validator v;

    @BeforeAll
    public static void beforeAll() {
        v = new Validator();
    }


    @Test
    void testStringValidator() {
        StringSchema schema = v.string();

        assertThat(schema.isValid("")).isTrue();
        assertThat(schema.isValid(5)).isFalse();
        assertThat(schema.isValid("valid")).isTrue();

        schema.required();
        assertThat(schema.isValid("")).isFalse();

        schema.minLength(3);
        assertThat(schema.isValid("true")).isTrue();
        assertThat(schema.isValid("no")).isFalse();

        assertThat(schema.contains("what").isValid("what does the fox say")).isTrue();
        assertThat(schema.contains("whale").isValid("what does the fox say")).isFalse();
        assertThat(schema.contains("wha").isValid("what does the fox say")).isTrue();
    }

    @Test
    void testNumberValidator() {
        NumberSchema schema = v.number();

        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid(0)).isTrue();

        assertThat(schema.positive().isValid(null)).isTrue();
        assertThat(schema.positive().isValid(-5)).isFalse();
        assertThat(schema.positive().isValid(0)).isFalse();

        schema.required();

        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid("0")).isFalse();
        assertThat(schema.isValid(-5)).isFalse();
        assertThat(schema.isValid(4)).isTrue();

        schema.range(3, 11);

        assertThat(schema.isValid(3)).isTrue();
        assertThat(schema.isValid(4)).isTrue();
        assertThat(schema.isValid(0)).isFalse();
        assertThat(schema.isValid(12)).isFalse();
    }

    @Test
    void testMapValidator() {
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
        MapSchema schema = v.map();

        Map<Object, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
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
        human4.put("age", -5);
        assertThat(schema.isValid(human4)).isFalse();
    }
}

package hexlet.code;

import hexlet.code.Schemas.NumberSchema;
import hexlet.code.Schemas.StringSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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
}

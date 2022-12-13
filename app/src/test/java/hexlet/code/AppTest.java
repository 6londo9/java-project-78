package hexlet.code;

import hexlet.code.schemas.StringSchema;
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
}

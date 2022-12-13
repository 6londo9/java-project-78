package hexlet.code.Schemas;

public interface BaseSchema {
    boolean isValid(Object schema);
    void required();
}

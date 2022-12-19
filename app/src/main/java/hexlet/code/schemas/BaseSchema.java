package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private final Map<String, Predicate> checks = new LinkedHashMap<>();

    public final boolean isValid(Object newSchema) {
        for (Map.Entry<String, Predicate> entry : checks.entrySet()) {
            if (!entry.getValue().test(newSchema)) {
                return false;
            }
        }
        return true;
    }

    public final void addCheck(String checkName, Predicate checkValue) {
        checks.put(checkName, checkValue);
    }
}

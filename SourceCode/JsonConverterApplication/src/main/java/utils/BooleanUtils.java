package utils;

import java.util.Arrays;
import java.util.List;

/**
 * class to handle boolean values
 */
public final class BooleanUtils {
    private static final List<String> VALID_BOOLEAN_VALUES =
            Arrays.asList("true", "false", "yes", "on", "no", "off");
    private static final List<String> VALID_BOOLEAN_TRUE_VALUES =
            Arrays.asList("yes", "on", "true");

    /**
     * extract the boolean value
     * @param value check if the string if belongs to boolean mappings
     * @return the exact the boolean value from the list of strings like on,off,yes,no
     */
    public static boolean getValue(String value) {
        return VALID_BOOLEAN_TRUE_VALUES.contains(value.toLowerCase());
    }

    /**
     * check if the string is a boolean type value
     * @param value check the value if it is a boolean type
     * @return true,if the string is of type boolean
     */
    public static boolean isBoolean(String value) {
        return VALID_BOOLEAN_VALUES.contains(value.toLowerCase());
    }

    private BooleanUtils() {
    }
}

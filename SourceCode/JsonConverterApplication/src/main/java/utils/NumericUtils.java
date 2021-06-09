package utils;

/**
 * Numeric values converter util class
 */
public final class NumericUtils {

    /**
     * convert the string into numeric values
     * @param value check if the String type belongs to numeric
     * @return double as the value
     */
    public static double getValue(String value) {
        return Double.parseDouble(value);
    }

    /**
     * check if the string is a numeric type
     * @param value check if the string belongs to numeric values
     * @return boolean if the string is a number type
     */
    public static boolean isNumeric(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private NumericUtils() {
    }
}

package utils;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BooleanUtilsTest {
    @Test
    public void isBoolean_valid_boolean_true_success() {
        Boolean valid = BooleanUtils.isBoolean("yes");
        assertTrue(valid);
    }

    @Test
    public void isBoolean_valid_boolean_false_success() {
        Boolean valid = BooleanUtils.isBoolean("off");
        assertTrue(valid);
    }

    @Test
    public void isBoolean_true_getvalue_success() {
        Boolean valid = BooleanUtils.getValue("on");
        assertTrue(valid);
    }

    @Test
    public void isBoolean_false_getvalue_success() {
        Boolean invalid = BooleanUtils.getValue("off");
        assertFalse(invalid);
    }
}


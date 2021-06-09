package utils;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class NumericUtilsTest {

    @Test
    public void isNumeric_valid_true_success() {
        Boolean valid = NumericUtils.isNumeric("2.56");
        assertTrue(valid);
    }

    @Test
    public void isNumeric_invalid_false_success() {
        Boolean invalid = NumericUtils.isNumeric("hello");
        assertFalse(invalid);
    }

    @Test
    public void getValue_valid_number_true_success() {
        Double validnumber = NumericUtils.getValue("2.56");;
        assertEquals(2.56, validnumber, 0);
    }

    @Test
    public void getValue_valid_id_true_success() {
        Double validnumber = NumericUtils.getValue("25776");
        assertEquals(25776, validnumber, 0);
    }
}

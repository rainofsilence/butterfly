package cn.silence.butterfly.core.util;

import org.junit.jupiter.api.Test;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/4/20 20:27
 */
class DataConvertUtilsTest {

    @Test
    void testToString() {
        String s = null;
        Float f = null;
        System.out.println(DataConvertUtils.toString(s));
        System.out.println(DataConvertUtils.toString(f));
    }

    @Test
    void testToInt() {
        System.out.println(DataConvertUtils.toInt(null));
        System.out.println(DataConvertUtils.toInt("11"));
    }

    @Test
    void testToBigDecimal() {
        System.out.println(DataConvertUtils.toBigDecimal("20.00"));
    }
}
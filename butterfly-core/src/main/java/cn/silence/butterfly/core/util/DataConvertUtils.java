package cn.silence.butterfly.core.util;

import java.math.BigDecimal;

/**
 * 字段类型转换及赋默认值工具类
 *
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/4/20 15:47
 */
public class DataConvertUtils {

    private DataConvertUtils() {
    }

    public static String toString(String s) {
        return s == null ? "" : s;
    }

    public static String toString(Double d) {
        return d == null ? "" : String.valueOf(d);
    }

    public static String toString(Integer i) {
        return i == null ? "" : String.valueOf(i);
    }

    public static String toString(BigDecimal b) {
        return b == null ? "" : b.toString();
    }

    public static String toString(Float f) {
        return f == null ? "" : String.valueOf(f);
    }

    public static String toString(Short st) {
        return st == null ? "" : String.valueOf(st);
    }

    public static int toInt(String s) {
        if (s == null || s.length() == 0) return 0;
        return Integer.parseInt(s);
    }

    public static BigDecimal toBigDecimal(String s) {
        if (s == null || s.length() == 0) return BigDecimal.ZERO;
        return new BigDecimal(s);
    }
}

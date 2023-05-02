package cn.silence.butterfly.core.util;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/04/18 23:49:42
 */
public class ArrayUtils {

    /**
     * 限制创建实例
     */
    private ArrayUtils() {
    }

    /**
     * 是否为空
     *
     * @param array 数组类型
     * @param <T>   泛型
     * @return true:为空
     */
    public static <T> boolean isEmpty(T[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断数组中是否存在指定元素
     *
     * @param arrays 数组
     * @param val    校验的元素
     * @param <T>    数组原始类型
     * @return 是否存在
     */
    public static <T> boolean contains(T[] arrays, T val) {
        if (arrays == null) {
            return false;
        }
        for (T t : arrays) {
            if (Objects.equals(t, val)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 数组或集合转String
     *
     * @param object 集合或数组对象
     * @return 数组字符串，与集合转字符串格式相同
     */
    public static String toString(Object object) {
        if (null == object) {
            return null;
        }

        if (object instanceof long[]) {
            return Arrays.toString((long[]) object);
        } else if (object instanceof int[]) {
            return Arrays.toString((int[]) object);
        } else if (object instanceof short[]) {
            return Arrays.toString((short[]) object);
        } else if (object instanceof char[]) {
            return Arrays.toString((char[]) object);
        } else if (object instanceof byte[]) {
            return Arrays.toString((byte[]) object);
        } else if (object instanceof boolean[]) {
            return Arrays.toString((boolean[]) object);
        } else if (object instanceof float[]) {
            return Arrays.toString((float[]) object);
        } else if (object instanceof double[]) {
            return Arrays.toString((double[]) object);
        } else if (ObjectUtils.isArray(object)) {
            // 对象数组
            try {
                return Arrays.deepToString((Object[]) object);
            } catch (Exception ignore) {
                // ignore
            }
        }
        return object.toString();
    }
}

package cn.silence.butterfly.core.util;

import java.time.temporal.TemporalAccessor;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/04/21 22:39:16
 */
public class ObjectUtils {

    private ObjectUtils() {
    }


    /**
     * 如果obj为null，则返回默认值，不为null，则返回obj
     *
     * @param object       object
     * @param defaultValue 默认值
     * @param <T>          值泛型
     * @return obj不为null 返回obj，否则返回默认值
     */
    public static <T> T defaultIfNull(T object, T defaultValue) {
        return object != null ? object : defaultValue;
    }

    //---------------------------------------------------------------------
    // 对象类型判断
    //---------------------------------------------------------------------

    public static boolean isCollection(Object object) {
        return object instanceof Collection;
    }

    public static boolean isMap(Object object) {
        return object instanceof Map;
    }

    public static boolean isNumber(Object object) {
        return object instanceof Number;
    }

    public static boolean isBoolean(Object object) {
        return object instanceof Boolean;
    }

    public static boolean isEnum(Object object) {
        return object instanceof Enum;
    }

    public static boolean isDate(Object object) {
        return object instanceof Date || object instanceof TemporalAccessor;
    }

    public static boolean isCharSequence(Object object) {
        return object instanceof CharSequence;
    }

    /**
     * 判断对象是否为八大基本类型包装类除外即(boolean, byte, char, short, int, long, float, and double)<br/>
     *
     * @param object
     * @return
     */
    public static boolean isPrimitive(Object object) {
        return object != null && object.getClass().isPrimitive();
    }

    /**
     * 判断对象是否为包装类或者非包装类的基本类型
     *
     * @param object
     * @return
     */
    public static boolean isWrapperOrPrimitive(Object object) {
        return isPrimitive(object) || isNumber(object) || isCharSequence(object) || isBoolean(object);
    }

    /**
     * 判断一个对象是否为数组
     *
     * @param object
     * @return
     */
    public static boolean isArray(Object object) {
        return object != null && object.getClass().isArray();
    }

    /**
     * 判断一个对象是否为基本类型数组即(int[], long[], boolean[], double[]....)
     *
     * @param object
     * @return
     */
    public static boolean isPrimitiveArray(Object object) {
        return isArray(object) && object.getClass().getComponentType().isPrimitive();
    }
}

package cn.silence.butterfly.core.exception;

import cn.silence.butterfly.core.util.ArrayUtils;
import cn.silence.butterfly.core.util.CollectionUtils;
import cn.silence.butterfly.core.util.MapUtils;
import cn.silence.butterfly.core.util.StrUtils;
import cn.silence.butterfly.core.util.result.ErrorCode;
import cn.silence.butterfly.core.util.result.ErrorCodeMessage;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * 业务断言类，不满足断言条件的都抛{@link BizException}
 * (默认{@link BizException#getErrorCode()}  errorCode}错误码为{@link ErrorCode#PARAM_ERROR}中的{@code code}值,即'403').
 * <br/>
 * <br/>
 * 各个系统可通过{@link #setDefaultErrorCode}为其指定独有的默认错误码,方便问题溯源.
 * 如微服务系统中为sys服务设置默认错误码,则可以在main方法中进行如下设置: {@code BizAssert.setDefaultErrorCode("SYSOO1")},
 * 那么如果使用该类对业务进行逻辑断言时,不满足期望时业务异常({@link BizException})中的错误码都将会是SYS001.
 * <br/>
 * <br/>
 * 若存在不方便使用断言的情况,需手动抛业务异常,也可使用{@link #newException(String)}的简单工厂来生成业务异常,
 * 如{@code throw BizAssert.newException("该用户名已存在")},
 * 那么该业务异常的错误码也会使用全局设置的默认错误码,避免手动为业务异常赋值错误码.
 *
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/04/18 23:33:30
 */
public final class BizAssert {

    public static String defaultErrorCode = ErrorCode.PARAM_ERROR.getCode();

    /**
     * 设置默认错误消息，可根据不同模块设置不同错误码，方便问题溯源
     *
     * @param errorCode 默认错误码
     */
    public static void setDefaultErrorCode(String errorCode) {
        defaultErrorCode = errorCode;
    }

    private BizAssert() {
    }

    /**
     * 断言对象不为空
     *
     * @param object  对象
     * @param message 不满足断言的异常信息
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw newException(message);
        }
    }

    /**
     * 断言对象不为空
     *
     * @param object   对象
     * @param supplier 错误消息供应器
     */
    public static void notNull(Object object, Supplier<String> supplier) {
        if (object == null) {
            throw newException(supplier.get());
        }
    }

    /**
     * 断言对象不能为空
     *
     * @param object       对象
     * @param errorMessage 错误枚举值
     */
    public static void notNull(Object object, ErrorCodeMessage errorMessage, Object... params) {
        if (object == null) {
            throw newException(errorMessage, params);
        }
    }

    /**
     * 断言字符串不能为空
     *
     * @param str     字符串
     * @param message 错误信息
     */
    public static void notBlank(String str, String message) {
        if (StrUtils.isBlank(str)) {
            throw newException(message);
        }
    }

    /**
     * 断言对象为空
     *
     * @param object  对象
     * @param message 不满足断言的异常信息
     */
    public static void isNull(Object object, String message) {
        isTrue(object == null, message);
    }

    /**
     * 断言对象为空
     *
     * @param object   obj
     * @param supplier 错误消息提供器
     */
    public static void isNull(Object object, Supplier<String> supplier) {
        isTrue(object == null, supplier);
    }

    /**
     * 断言对象为空
     *
     * @param object       obj
     * @param errorMessage 错误枚举
     */
    public static void isNull(Object object, ErrorCodeMessage errorMessage, Object... params) {
        isTrue(object == null, errorMessage, params);
    }


    /**
     * 断言字符串不为空
     *
     * @param str     字符串
     * @param message 不满足断言的异常信息
     */
    public static void notEmpty(String str, String message) {
        isTrue(!StrUtils.isEmpty(str), message);
    }

    /**
     * 断言字符串不为空
     *
     * @param str      字符串
     * @param supplier 错误消息供应器
     */
    public static void notEmpty(String str, Supplier<String> supplier) {
        isTrue(!StrUtils.isEmpty(str), supplier);
    }

    /**
     * 断言字符串不为空
     *
     * @param str          字符串
     * @param errorMessage 错误枚举
     */
    public static void notEmpty(String str, ErrorCodeMessage errorMessage, Object... params) {
        isTrue(!StrUtils.isEmpty(str), errorMessage, params);
    }

    /**
     * 断言集合不为空
     *
     * @param collection 集合
     * @param message    不满足断言的异常信息
     */
    public static void notEmpty(Collection<?> collection, String message) {
        isTrue(CollectionUtils.isNotEmpty(collection), message);
    }

    /**
     * 断言集合不为空
     *
     * @param collection 集合
     * @param supplier   不满足断言的异常信息提供者
     */
    public static void notEmpty(Collection<?> collection, Supplier<String> supplier) {
        isTrue(CollectionUtils.isNotEmpty(collection), supplier);
    }

    /**
     * 断言集合不为空
     *
     * @param collection   集合
     * @param errorMessage 错误枚举
     */
    public static void notEmpty(Collection<?> collection, ErrorCodeMessage errorMessage, Object... params) {
        isTrue(CollectionUtils.isNotEmpty(collection), errorMessage, params);
    }

    /**
     * 断言map不为空
     *
     * @param map     map
     * @param message 不满足断言的异常信息
     */
    public static void notEmpty(Map<?, ?> map, String message) {
        isTrue(!MapUtils.isEmpty(map), message);
    }

    /**
     * 断言map不为空
     *
     * @param map      map
     * @param supplier 错误消息供应器
     */
    public static void notEmpty(Map<?, ?> map, Supplier<String> supplier) {
        isTrue(!MapUtils.isEmpty(map), supplier);
    }

    /**
     * 断言map不为空
     *
     * @param map          map
     * @param errorMessage 错误枚举
     */
    public static void notEmpty(Map<?, ?> map, ErrorCodeMessage errorMessage, Object... params) {
        isTrue(!MapUtils.isEmpty(map), errorMessage, params);
    }

    /**
     * 断言集合为空
     *
     * @param collection 集合
     * @param message    不满足断言的异常信息
     */
    public static void empty(Collection<?> collection, String message) {
        isTrue(CollectionUtils.isEmpty(collection), message);
    }

    /**
     * 断言集合为空
     *
     * @param collection 集合
     * @param supplier   不满足断言的异常信息提供器
     */
    public static void empty(Collection<?> collection, Supplier<String> supplier) {
        isTrue(CollectionUtils.isEmpty(collection), supplier);
    }

    /**
     * 断言集合为空
     *
     * @param collection   集合
     * @param errorMessage 错误枚举
     */
    public static void empty(Collection<?> collection, ErrorCodeMessage errorMessage, Object... params) {
        isTrue(CollectionUtils.isEmpty(collection), errorMessage, params);
    }

    /**
     * 断言两个对象必须相等
     *
     * @param o1      对象1
     * @param o2      对象2
     * @param message 错误消息
     */
    public static void equals(Object o1, Object o2, String message) {
        isTrue(Objects.equals(o1, o2), message);
    }

    /**
     * 断言两个对象必须相等
     *
     * @param o1          对象1
     * @param o2          对象2
     * @param msgSupplier 错误消息提供器
     */
    public static void equals(Object o1, Object o2, Supplier<String> msgSupplier) {
        isTrue(Objects.equals(o1, o2), msgSupplier);
    }

    /**
     * 断言两个对象必须相等
     *
     * @param o1           对象1
     * @param o2           对象2
     * @param errorMessage 错误枚举
     */
    public static void equals(Object o1, Object o2, ErrorCodeMessage errorMessage, Object... params) {
        isTrue(Objects.equals(o1, o2), errorMessage, params);
    }


    /**
     * 断言两个对象不相等
     *
     * @param o1      对象1
     * @param o2      对象2
     * @param message 错误消息
     */
    public static void notEquals(Object o1, Object o2, String message) {
        isTrue(!Objects.equals(o1, o2), message);
    }

    /**
     * 断言两个对象不相等
     *
     * @param o1          对象1
     * @param o2          对象2
     * @param msgSupplier 错误消息提供器
     */
    public static void notEquals(Object o1, Object o2, Supplier<String> msgSupplier) {
        isTrue(!Objects.equals(o1, o2), msgSupplier);
    }

    /**
     * 断言两个对象不相等
     *
     * @param o1           对象1
     * @param o2           对象2
     * @param errorMessage 错误枚举
     */
    public static void notEquals(Object o1, Object o2, ErrorCodeMessage errorMessage, Object... params) {
        isTrue(!Objects.equals(o1, o2), errorMessage, params);
    }

    /**
     * 断言对象数组包含指定元素
     *
     * @param o1      对象1
     * @param objs    对象2
     * @param message 错误消息
     */
    public static <T> void contains(T o1, T[] objs, String message) {
        isTrue(ArrayUtils.contains(objs, o1), message);
    }

    /**
     * 断言对象数组包含指定元素
     *
     * @param o1          对象1
     * @param objs        对象2
     * @param msgSupplier 错误消息提供器
     */
    public static <T> void contains(T o1, T[] objs, Supplier<String> msgSupplier) {
        isTrue(ArrayUtils.contains(objs, o1), msgSupplier);
    }

    /**
     * 断言对象数组包含指定元素
     *
     * @param o1           对象1
     * @param objs         对象2
     * @param errorMessage 错误枚举
     */
    public static <T> void contains(T o1, T[] objs, ErrorCodeMessage errorMessage, Object... params) {
        isTrue(ArrayUtils.contains(objs, o1), errorMessage, params);
    }


    /**
     * 断言一个boolean表达式为true
     *
     * @param expression boolean表达式
     * @param message    不满足断言的异常信息
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw newException(message);
        }
    }

    /**
     * 断言一个boolean表达式为true，用于需要大量拼接字符串以及一些其他操作等
     *
     * @param expression boolean表达式
     * @param supplier   msg生产者
     */
    public static void isTrue(boolean expression, Supplier<String> supplier) {
        if (!expression) {
            throw newException(supplier.get());
        }
    }

    /**
     * 断言一个boolean表达式为true，用于需要大量拼接字符串以及一些其他操作等
     *
     * @param expression   boolean表达式
     * @param errorMessage 错误枚举
     */
    public static void isTrue(boolean expression, ErrorCodeMessage errorMessage, Object... params) {
        if (!expression) {
            throw newException(errorMessage, params);
        }
    }

    /**
     * 创建业务运行时异常对象
     *
     * @param message 异常信息
     * @return 异常
     */
    public static BizException newException(String message) {
        return new BizException(defaultErrorCode, message);
    }

    /**
     * 创建业务运行时异常对象，并将异常的填充进参数msg
     *
     * @param message 异常信息，可使用 '%s' 接受异常消息
     * @param e       包装异常
     * @return 异常
     */
    public static BizException newException(String message, Exception e) {
        return new BizException(defaultErrorCode, String.format(message, e.getMessage()));
    }

    /**
     * 创建业务运行时异常对象
     *
     * @param errorMessage 错误枚举
     * @return 异常
     */
    public static BizException newException(ErrorCodeMessage errorMessage, Object... params) {
        return new BizException(errorMessage, params);
    }
}

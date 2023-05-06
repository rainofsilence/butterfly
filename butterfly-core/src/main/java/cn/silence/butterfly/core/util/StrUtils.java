package cn.silence.butterfly.core.util;

import cn.silence.butterfly.core.util.text.StrPool;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 字符串工具类
 *
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/4/17 08:19
 */
public final class StrUtils implements StrPool {

    /**
     * 限制创建实例
     */
    private StrUtils() {
    }

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isBlank(CharSequence cs) {
        if (cs == null) return true;
        int strLen = 0;
        for (int i = 0; i < cs.length(); i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    //-------------------------------------------------------------------------------------------------------------camel

    /**
     * 驼峰字符串转下划线字符串
     *
     * @param camelStr
     * @return
     */
    public static String camel2Underscore(String camelStr) {
        return convertCamel(camelStr, '_');
    }

    /**
     * 转换驼峰字符串为指定分隔符的字符串<br/>
     * For example: camelStr:"UserInfo" separator:'_' <br/>
     * return "user_info"
     *
     * @param camelStr
     * @param separator
     * @return
     */
    public static String convertCamel(String camelStr, char separator) {
        if (isEmpty((camelStr))) return camelStr;
        StringBuilder sbOut = new StringBuilder();
        char[] chars = camelStr.toCharArray();
        for (int i = 0, len = chars.length; i < len; i++) {
            char c = chars[i];
            if (Character.isUpperCase(c)) {
                if (i != 0) {
                    sbOut.append(separator);
                }
                sbOut.append(Character.toLowerCase(c));
                continue;
            }
            sbOut.append(c);
        }
        return sbOut.toString();
    }

    //---------------------------------------------------------------------------------------------------------------str

    /**
     * 将对象转为字符串<br>
     *
     * <pre>
     * 1、Byte数组和ByteBuffer会被转换为对应字符串的数组
     * 2、对象数组会调用Arrays.toString方法
     * </pre>
     *
     * @param object 对象
     * @return 字符串
     */
    public static String toUtf8Str(Object object) {
        return toStr(object, StandardCharsets.UTF_8);
    }

    /**
     * 将对象转为字符串
     *
     * <pre>
     * 1、Byte数组和ByteBuffer会被转换为对应字符串的数组
     * 2、对象数组会调用Arrays.toString方法
     * </pre>
     *
     * @param object      对象
     * @param charsetName 字符集
     * @return 字符串
     * @deprecated 请使用 {@link #toStr(Object, Charset)}
     */
    @Deprecated
    public static String toStr(Object object, String charsetName) {
        return toStr(object, Charset.forName(charsetName));
    }

    /**
     * 将对象转为字符串
     * <pre>
     * 	 1、Byte数组和ByteBuffer会被转换为对应字符串的数组
     * 	 2、对象数组会调用Arrays.toString方法
     * </pre>
     *
     * @param object  对象
     * @param charset 字符集
     * @return 字符串
     */
    public static String toStr(Object object, Charset charset) {
        if (null == object) {
            return null;
        }

        if (object instanceof String) {
            return (String) object;
        } else if (object instanceof byte[]) {
            return toStr((byte[]) object, charset);
        } else if (object instanceof Byte[]) {
            return toStr((Byte[]) object, charset);
        } else if (object instanceof ByteBuffer) {
            return toStr((ByteBuffer) object, charset);
        } else if (ObjectUtils.isArray(object)) {
            return ArrayUtils.toString(object);
        }
        return object.toString();
    }

    //------------------------------------------------------------------------------------------------------------format

    /**
     * 格式化文本, {} 表示占位符<br>
     * 此方法只是简单将占位符 {} 按照顺序替换为参数<br>
     * 如果想输出 {} 使用 \\转义 { 即可，如果想输出 {} 之前的 \ 使用双转义符 \\\\ 即可<br>
     * 例：<br>
     * 通常使用：format("this is {} for {}", "a", "b") =》 this is a for b<br>
     * 转义{}： format("this is \\{} for {}", "a", "b") =》 this is {} for a<br>
     * 转义\： format("this is \\\\{} for {}", "a", "b") =》 this is \a for b<br>
     *
     * @param template 文本模板，被替换的部分用 {} 表示，如果模板为null，返回"null"
     * @param params   参数值
     * @return 格式化后的文本，如果模板为null，返回"null"
     */
    public static String format(CharSequence template, Object... params) {
        if (null == template) {
            return NULL;
        }
        if (ArrayUtils.isEmpty(params) || isBlank(template)) {
            return template.toString();
        }
        return StrFormatter.format(template.toString(), params);
    }
}

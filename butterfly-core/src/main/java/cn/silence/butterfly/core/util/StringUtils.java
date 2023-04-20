package cn.silence.butterfly.core.util;

/**
 * 字符串工具类
 *
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/4/17 08:19
 */
public final class StringUtils {

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

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
}

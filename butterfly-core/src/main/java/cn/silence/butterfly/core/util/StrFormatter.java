package cn.silence.butterfly.core.util;

import java.util.Map;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/02 12:44:09
 */
public class StrFormatter {

    /**
     * 格式化字符串<br>
     * 此方法只是简单将占位符 {} 按照顺序替换为参数<br>
     * 如果想输出 {} 使用 \\转义 { 即可，如果想输出 {} 之前的 \ 使用双转义符 \\\\ 即可<br>
     * 例：<br>
     * 通常使用：format("this is {} for {}", "a", "b") =》 this is a for b<br>
     * 转义{}： format("this is \\{} for {}", "a", "b") =》 this is \{} for a<br>
     * 转义\： format("this is \\\\{} for {}", "a", "b") =》 this is \a for b<br>
     *
     * @param strPattern 字符串模板
     * @param argArray   参数列表
     * @return 结果
     */
    public static String format(String strPattern, Object... argArray) {
        return formatWith(strPattern, StrUtils.EMPTY_JSON, argArray);
    }

    /**
     * 格式化字符串<br>
     * 此方法只是简单将指定占位符 按照顺序替换为参数<br>
     * 如果想输出占位符使用 \\转义即可，如果想输出占位符之前的 \ 使用双转义符 \\\\ 即可<br>
     * 例：<br>
     * 通常使用：format("this is {} for {}", "{}", "a", "b") =》 this is a for b<br>
     * 转义{}： format("this is \\{} for {}", "{}", "a", "b") =》 this is {} for a<br>
     * 转义\： format("this is \\\\{} for {}", "{}", "a", "b") =》 this is \a for b<br>
     *
     * @param strPattern  字符串模板
     * @param placeHolder 占位符，例如{}
     * @param argArray    参数列表
     * @return 结果
     */
    public static String formatWith(String strPattern, String placeHolder, Object... argArray) {
        if (StrUtils.isBlank(strPattern) || StrUtils.isBlank(placeHolder) || ArrayUtils.isEmpty(argArray)) {
            return strPattern;
        }
        final int strPatternLength = strPattern.length();
        final int placeHolderLength = placeHolder.length();

        // 初始化定义好的长度以获得更好的性能
        final StringBuilder sbUF = new StringBuilder(strPatternLength + 50);

        int handledPosition = 0;// 记录已经处理到的位置
        int delimIndex;// 占位符所在位置
        for (int argIndex = 0; argIndex < argArray.length; argIndex++) {
            delimIndex = strPattern.indexOf(placeHolder, handledPosition);
            if (delimIndex == -1) {// 剩余部分无占位符
                if (handledPosition == 0) { // 不带占位符的模板直接返回
                    return strPattern;
                }
                // 字符串模板剩余部分不再包含占位符，加入剩余部分后返回结果
                sbUF.append(strPattern, handledPosition, strPatternLength);
                return sbUF.toString();
            }

            // 转义符
            if (delimIndex > 0 && strPattern.charAt(delimIndex - 1) == StrUtils.C_BACKSLASH) {// 转义符
                if (delimIndex > 1 && strPattern.charAt(delimIndex - 2) == StrUtils.C_BACKSLASH) {// 双转义符
                    // 转义符之前还有一个转义符，占位符依旧有效
                    sbUF.append(strPattern, handledPosition, delimIndex - 1);
                    sbUF.append(StrUtils.toUtf8Str(argArray[argIndex]));
                    handledPosition = delimIndex + placeHolderLength;
                } else {
                    // 占位符被转义
                    argIndex--;
                    sbUF.append(strPattern, handledPosition, delimIndex - 1);
                    sbUF.append(placeHolder.charAt(0));
                    handledPosition = delimIndex + 1;
                }
            } else {// 正常占位符
                sbUF.append(strPattern, handledPosition, delimIndex);
                sbUF.append(StrUtils.toUtf8Str(argArray[argIndex]));
                handledPosition = delimIndex + placeHolderLength;
            }
        }

        // 加入最后一个占位符后所有的字符
        sbUF.append(strPattern, handledPosition, strPatternLength);
        return sbUF.toString();
    }

    /**
     * 格式化文本，使用 {varName} 占位<br>
     * map = {a: "aValue", b: "bValue"} format("{a} and {b}", map) ---=》 aValue and bValue
     *
     * @param template   文本模板，被替换的部分用 {key} 表示
     * @param map        参数值对
     * @param ignoreNull 是否忽略 {@code null} 值，忽略则 {@code null} 值对应的变量不被替换，否则替换为""
     * @return 格式化后的文本
     */
    public static String format(CharSequence template, Map<?, ?> map, boolean ignoreNull) {
        if (null == template) {
            return null;
        }
        if (null == map || map.isEmpty()) {
            return template.toString();
        }

        String templateTarget = template.toString();
        String value;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            value = StrUtils.toUtf8Str(entry.getValue());
            if (null == value && ignoreNull) {
                continue;
            }
            templateTarget = templateTarget.replace("{" + entry.getKey() + "}", value == null ? "" : value);
        }
        return templateTarget;
    }
}

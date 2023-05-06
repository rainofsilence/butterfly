package cn.silence.butterfly.core.util;

import java.util.ArrayList;
import java.util.List;

/**
 * csv工具类
 *
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/06 22:01:56
 */
public class CSVUtils {

    public static final char DEFAULT_SEPARATOR = ','; // 默认分隔号 ','
    public static final char DEFAULT_QUOTE = '"'; // 默认包围符号 '"'

    /**
     * @param curLine csv当前行
     * @return 获取当前行List<String>
     */
    public static List<String> parseLine(String curLine) {
        return parseLine(curLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
    }

    /**
     * @param curLine   csv当前行
     * @param separator 分隔符
     * @return 获取当前行List<String>
     */
    public static List<String> parseLine(String curLine, char separator) {
        return parseLine(curLine, separator, DEFAULT_QUOTE);
    }

    /**
     * @param curLine   csv当前行
     * @param separator 分隔符
     * @param quote     包围号
     * @return 获取当前行List<String>
     */
    public static List<String> parseLine(String curLine, char separator, char quote) {
        List<String> result = new ArrayList<>();
        if (curLine == null || curLine.length() == 0) return result;
        if (quote == ' ') quote = DEFAULT_QUOTE;
        if (separator == ' ') separator = DEFAULT_SEPARATOR;
        StringBuilder curVal = new StringBuilder();
        boolean inQuotes = false;
        boolean startCollectChar = false;
        boolean doubleQuotesInColumn = false;
        char[] chars = curLine.toCharArray();
        for (char ch : chars) {
            if (inQuotes) {
                startCollectChar = true;
                if (ch == quote) {
                    inQuotes = false;
                    doubleQuotesInColumn = false;
                } else {
                    // Fixed : allow "" in custom quote enclosed
                    if (ch == '\"') {
                        if (!doubleQuotesInColumn) {
                            curVal.append(ch);
                            doubleQuotesInColumn = true;
                        }
                    } else {
                        curVal.append(ch);
                    }
                }
                continue;
            }

            if (ch == quote) {
                inQuotes = true;
                // Fixed : allow "" in empty quote enclosed
                if (chars[0] != '"' && quote == '\"') {
                    curVal.append('"');
                }
                // double quotes in column will hit this!
                if (startCollectChar) {
                    curVal.append('"');
                }
            } else if (ch == separator) {
                result.add(curVal.toString());
                curVal = new StringBuilder();
                startCollectChar = false;

            } else if (ch == '\r') {
                // ignore LF characters
                continue;
            } else if (ch == '\n') {
                // the end, break!
                break;
            } else {
                curVal.append(ch);
            }
        }
        result.add(curVal.toString());
        return result;
    }


}

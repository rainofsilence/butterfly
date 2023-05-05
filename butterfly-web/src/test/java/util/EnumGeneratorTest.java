package util;

import cn.silence.butterfly.core.util.JSONUtils;
import cn.silence.butterfly.core.util.StrUtils;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/03 22:53:22
 */
class EnumGeneratorTest {

    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE = '"';

    private static final String RELATIVELY_PATH = String.format("%s\\src\\test\\resources\\uncommits", System.getProperty("user.dir"));
    private static final String FILENAME = "code.csv";
    private static final String FILEPATH = String.format("%s\\%s", RELATIVELY_PATH, FILENAME);

    /**
     * // TODO
     * 通过 CSV 文件自动生成系统枚举值插入语句
     */
    @Test
    void generateByCSV() throws Exception {
        System.out.println("Enum init sql is start");
        System.out.println("Filepath1==> " + FILEPATH);
        try (BufferedReader br = new BufferedReader(new FileReader(FILEPATH))) {
            String curLine;
            while ((curLine = br.readLine()) != null) {
                List<String> lines = parseLine(curLine);
                System.out.println(JSONUtils.toJSONString(lines));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> parseLine(String curLine) {
        return parseLine(curLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
    }

    public static List<String> parseLine(String curLine, char separators) {
        return parseLine(curLine, separators, DEFAULT_QUOTE);
    }

    public static List<String> parseLine(String curLine, char separator, char quote) {
        List<String> result = new ArrayList<>();
        // if empty, return!
        if (StrUtils.isBlank(curLine)) {
            return result;
        }
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
            } else {
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
        }
        result.add(curVal.toString());
        return result;
    }
}

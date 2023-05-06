package util;

import cn.silence.butterfly.core.exception.UtilException;
import cn.silence.butterfly.core.util.CSVUtils;
import cn.silence.butterfly.core.util.UUIDUtils;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/03 22:53:22
 */
class EnumGeneratorTest {

    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE = '"';

    // TODO 使用前请将确认csv文件路径
    private static final String FILEPATH =
            String.format("%s\\src\\test\\resources\\%s",
                    System.getProperty("user.dir"),
                    "uncommits\\code.csv");

    /**
     * 通过 CSV 文件自动生成系统枚举值插入语句
     */
    @Test
    void generateByCSV() {
        System.out.println("EnumGeneratorTest.generateByCSV start, FILEPATH:\n" + FILEPATH);
        try (BufferedReader br = new BufferedReader(new FileReader(FILEPATH))) {
            String curLine;
            System.out.println("==>");
            while ((curLine = br.readLine()) != null) {
                List<String> lines = CSVUtils.parseLine(curLine);
                // System.out.println(JSONUtils.toJSONString(lines));
                System.out.printf("delete from enum_info where parent_no = '%s' and sub_no = '%s';%n",
                        lines.get(0), lines.get(2));
                System.out.printf(
                        "insert into enum_info (id, parent_no, parent_name, sub_no, sub_name, remark, create_username, update_username) values ('%s','%s','%s','%s','%s','%s','%s','%s');%n",
                        UUIDUtils.generate32UUID(), lines.get(0), lines.get(1), lines.get(2), lines.get(3), lines.get(4), "system", "system");

            }
            System.out.println("==>");
        } catch (Exception e) {
            throw new UtilException(e.getMessage());
        }
    }
}

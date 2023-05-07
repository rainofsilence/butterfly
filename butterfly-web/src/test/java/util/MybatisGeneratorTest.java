package util;

import org.junit.jupiter.api.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/04 23:02:22
 */
class MybatisGeneratorTest {

    @Test
    void generator() throws Exception {
        // MBG执行过程中的警告信息
        List<String> warnings = new ArrayList<String>();
        // 生成代码重复时，是否覆盖源代码
        boolean override = true;
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatisGeneratorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(in);

        DefaultShellCallback callback = new DefaultShellCallback(override);
        // 创建MBG
        MyBatisGenerator mbg = new MyBatisGenerator(config, callback, warnings);
        mbg.generate(null);
        // 输出警告信息
        for (String warn : warnings) {
            System.out.println(warn);
        }
    }
}

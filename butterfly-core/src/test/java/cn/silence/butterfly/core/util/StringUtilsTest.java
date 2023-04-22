package cn.silence.butterfly.core.util;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * @author rainofsilence
 * @date 2023/4/17 20:20
 * @desc
 */
class StringUtilsTest {

    @Test
    @Tag("success")
    void camel2Underscore() {
        System.out.println(StringUtils.camel2Underscore("HelloWorld"));
    }

    @Test
    @Tag("success")
    void convertCamel() {
        System.out.println(StringUtils.convertCamel("HelloWorld",'-'));
    }
}
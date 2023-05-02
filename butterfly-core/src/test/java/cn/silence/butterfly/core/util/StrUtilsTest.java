package cn.silence.butterfly.core.util;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * @author rainofsilence
 * @date 2023/4/17 20:20
 * @desc
 */
class StrUtilsTest {

    @Test
    @Tag("success")
    void camel2Underscore() {
        System.out.println(StrUtils.camel2Underscore("HelloWorld"));
    }

    @Test
    @Tag("success")
    void convertCamel() {
        System.out.println(StrUtils.convertCamel("HelloWorld", '-'));
    }

    @Test
    @Tag("success")
    void format() {
        System.out.println(StrUtils.format("This is [{}].", "StringUtils.format"));
        System.out.println(StrUtils.format("This is [{}]."));
        System.out.println(StrUtils.format("This is [{}].", null));
    }
}
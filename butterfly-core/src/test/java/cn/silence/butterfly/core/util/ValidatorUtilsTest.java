package cn.silence.butterfly.core.util;

import org.junit.jupiter.api.Test;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/4/20 15:25
 */
class ValidatorUtilsTest {

    @Test
    void isMobile() {
        System.out.println(ValidatorUtils.isMobile("13333333333"));
        System.out.println(ValidatorUtils.isMobile("133333333331"));
        System.out.println(ValidatorUtils.isMobile(null));
    }

    @Test
    void isEmail() {
        System.out.println(ValidatorUtils.isEmail("hello"));
        System.out.println(ValidatorUtils.isEmail("hello@163.com"));
    }
}
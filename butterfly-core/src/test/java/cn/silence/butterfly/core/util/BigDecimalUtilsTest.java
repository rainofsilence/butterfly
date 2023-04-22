package cn.silence.butterfly.core.util;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/4/20 09:13
 */
class BigDecimalUtilsTest {

    @Test
    @Tag("success")
    void between() {
        System.out.println(BigDecimalUtils.between(BigDecimal.TEN,BigDecimal.ZERO,BigDecimal.ONE));
        System.out.println(BigDecimalUtils.between(BigDecimal.ONE,BigDecimal.ZERO,BigDecimal.TEN));
    }
}
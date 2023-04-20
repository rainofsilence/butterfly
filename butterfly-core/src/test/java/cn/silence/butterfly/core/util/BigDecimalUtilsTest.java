package cn.silence.butterfly.core.util;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/4/20 09:13
 */
class BigDecimalUtilsTest {

    @Test
    void between() {
        System.out.println(BigDecimalUtils.between(BigDecimal.TEN,BigDecimal.ZERO,BigDecimal.ONE));
        System.out.println(BigDecimalUtils.between(BigDecimal.ONE,BigDecimal.ZERO,BigDecimal.TEN));
    }
}
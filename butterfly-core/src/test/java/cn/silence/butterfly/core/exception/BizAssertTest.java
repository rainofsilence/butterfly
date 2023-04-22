package cn.silence.butterfly.core.exception;

import cn.silence.butterfly.core.util.result.ErrorCode;
import org.junit.jupiter.api.Test;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/04/18 23:52:43
 */
class BizAssertTest {

    @Test
    void notNullTest() {
        String test = null;
        BizAssert.notNull(test, ErrorCode.PARAM_ERROR, "param error");
    }
}
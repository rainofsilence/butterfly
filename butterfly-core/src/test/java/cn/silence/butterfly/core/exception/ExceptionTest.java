package cn.silence.butterfly.core.exception;

import cn.silence.butterfly.core.util.JSONUtils;
import cn.silence.butterfly.core.util.result.ErrorCode;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/03 2:18:17
 */
class ExceptionTest {

    @Test
    @Tag("fail")
    void bizExceptionTest1() {
        System.out.println(JSONUtils.toJSONString(new BizException(ErrorCode.SERVER_ERROR.getCode(), "Test BizException")));
        throw new BizException(ErrorCode.SERVER_ERROR.getCode(), "Test BizException");
    }

    @Test
    @Tag("fail")
    void utilExceptionTest1() {
        System.out.println(JSONUtils.toJSONString(new UtilException("util error")));
        throw new UtilException("util error");
    }
}
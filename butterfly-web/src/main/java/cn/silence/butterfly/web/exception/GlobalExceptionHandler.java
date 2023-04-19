package cn.silence.butterfly.web.exception;

import cn.silence.butterfly.core.exception.BizException;
import cn.silence.butterfly.core.util.result.BaseResponse;
import cn.silence.butterfly.core.util.result.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/04/19 0:03:34
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BizException.class)
    public BaseResponse<?> bizExceptionHandler(BizException e) {
        log.error("bizException: errorCode={}, errorMessage={}", e.getErrorCode(), e.getMessage());
        return BaseResponse.of(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse<?> runtimeExceptionHandler(RuntimeException e) {
        log.error("runtimeException", e);
        return BaseResponse.of(ErrorCode.SERVER_ERROR.getCode(), e.getMessage());
    }
}

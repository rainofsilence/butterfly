package cn.silence.butterfly.core.exception;

import cn.silence.butterfly.core.util.result.ErrorCodeMessage;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/04/18 23:13:27
 */
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = -6962657798665147348L;

    private String errorCode;

    protected BaseException(String message) {
        super(message);
    }

    /**
     * @param errorMessage 错误消息
     * @param params
     */
    public BaseException(ErrorCodeMessage errorMessage, Object... params) {
        super(params == null ? errorMessage.getMessage() : errorMessage.getMessage(params));
        this.errorCode = errorMessage.getCode();
    }

    /**
     * @param errorCode 错误code
     * @param message   错误消息
     */
    public BaseException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}

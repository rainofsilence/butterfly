package cn.silence.butterfly.core.exception;

import cn.silence.butterfly.core.util.result.ErrorCodeMessage;

/**
 * 业务类异常
 *
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/04/18 23:31:49
 */
public class BizException extends BaseException {

    private static final long serialVersionUID = 6420799395951591450L;

    /**
     * @param errorMessage 错误消息
     */
    public BizException(ErrorCodeMessage errorMessage, Object... params) {
        super(errorMessage, params);
    }

    /**
     * @param errorCode 错误code
     * @param message   错误消息
     */
    public BizException(String errorCode, String message) {
        super(errorCode, message);
    }
}

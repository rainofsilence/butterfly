package cn.silence.butterfly.core.exception;

import cn.silence.butterfly.core.util.result.ErrorCode;

/**
 * 工具类异常
 *
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/03 2:00:26
 */
public class UtilException extends BaseException {
    private static final long serialVersionUID = -1368979121519167510L;

    /**
     * errorCode默认{@link cn.silence.butterfly.core.util.result.ErrorCode#UTIL_ERROR}
     *
     * @param message 错误消息
     */
    public UtilException(String message) {
        super(ErrorCode.UTIL_ERROR.getCode(), message);
    }
}

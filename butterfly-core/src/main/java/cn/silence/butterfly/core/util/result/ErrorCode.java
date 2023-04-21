package cn.silence.butterfly.core.util.result;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/04/18 23:21:25
 */
public enum ErrorCode implements ErrorCodeMessage {

    /**
     * 操作成功
     */
    SUCCESS("200", "success"),
    /**
     * 操作失败（通常为业务逻辑错误）
     */
    FAILURE("400", "failure"),
    /**
     * 参数错误
     */
    PARAM_ERROR("405", "参数错误"),
    /**
     * 资源未找到
     */
    NO_FOUND("404", "no found"),
    /**
     * 服务器异常（其他未知错误）
     */
    SERVER_ERROR("500", "server error"),
    /**
     * 无权限
     */
    NO_PERMISSION("501", "no permission");

    /**
     * 结果操作码
     */
    private final String code;
    /**
     * 结果消息
     */
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String getCode() {
        return this.code;
    }
}
package cn.silence.butterfly.core.util.result;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/04/18 23:14:54
 */
public interface ErrorCodeMessage {


    /**
     * 返回结果码
     *
     * @return code
     */
    String getCode();

    /**
     * 返回结果消息
     *
     * @return msg
     */
    String getMessage();

    /**
     * 获取完整带有占位符的错误消息
     *
     * @param params 占位符参数值
     * @return 完整错误消息
     */
    default String getMessage(Object... params) {
        return String.format(getMessage(), params);
    }

    /**
     * 转换为Result
     *
     * @param message 消息
     * @return {@linkplain BaseResponse}
     */
    default BaseResponse<?> toBaseResponse(String message) {
        return BaseResponse.of(this.getCode(), message);
    }

    /**
     * 转换为Result
     *
     * @param params 消息占位符参数
     * @return {@linkplain BaseResponse}
     */
    default BaseResponse<?> toBaseResponse(Object... params) {
        return BaseResponse.of(this, params);
    }
}

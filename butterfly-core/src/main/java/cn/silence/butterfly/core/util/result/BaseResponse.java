package cn.silence.butterfly.core.util.result;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/04/18 23:15:33
 */
public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = -290818142019558039L;

    private String code;

    private String message;

    private T data;

    public BaseResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> BaseResponse<T> of(String code, String message) {
        return new BaseResponse<>(code, message);
    }

    public static <T> BaseResponse<T> of(ErrorCodeMessage errorCodeMessage, Object... params) {
        return new BaseResponse<T>(errorCodeMessage.getCode(), params == null ? errorCodeMessage.getMessage() : errorCodeMessage.getMessage(params));
    }

    //---------------------------------------------------------------------
    // 各种结果对象的简单工厂，可使用Result.<T>success()调用返回指定泛型data值的对象(防止部分编译警告)
    //---------------------------------------------------------------------

    /**
     * 成功结果 （结果枚举为 {@linkplain ErrorCode#SUCCESS}）
     *
     * @param <T> data类型
     * @return result
     */
    public static <T> BaseResponse<T> success() {
        return of(ErrorCode.SUCCESS);
    }

    /**
     * 成功结果 （结果枚举为 {@linkplain ErrorCode#SUCCESS}）
     *
     * @param <T> data类型
     * @return result
     */
    public static <T> BaseResponse<T> success(T data) {
        return BaseResponse.<T>success().with(data);
    }

    /**
     * 接口只是定义还没真正实现时返回结果 （结果枚举为 {@linkplain ErrorCode#SERVICE_STILL_DEV}）
     *
     * @param <T> data类型
     * @return result
     */
    public static <T> BaseResponse<T> stillDev() {
        return of(ErrorCode.SERVICE_STILL_DEV);
    }

    /**
     * 接口只是定义还没真正实现时返回结果 （结果枚举为 {@linkplain ErrorCode#SERVICE_STILL_DEV}）
     *
     * @param <T> data类型
     * @return result
     */
    public static <T> BaseResponse<T> stillDev(T data) {
        return BaseResponse.<T>stillDev().with(data);
    }

    /**
     * 将数据对象添加进操作结果{@link BaseResponse}对象里
     *
     * @param data 数据对象
     * @return Result对象
     */
    public BaseResponse<T> with(T data) {
        this.data = data;
        return this;
    }

    /**
     * 判断该结果是否为成功的操作
     *
     * @return true: success
     */
    public boolean isSuccess() {
        return Objects.equals(this.code, ErrorCode.SUCCESS.getCode());
    }

    //---------------------------------------------------------------------
    // getter setter toString
    //---------------------------------------------------------------------

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

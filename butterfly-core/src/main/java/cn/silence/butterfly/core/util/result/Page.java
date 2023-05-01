package cn.silence.butterfly.core.util.result;

import java.util.Collections;
import java.util.List;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/5/1 16:20
 */
public class Page<T> {

    /**
     * 数据总数
     */
    private final Long total;
    /**
     * 指定页数数据列表
     */
    private final List<T> list;

    public Page(Long total, List<T> list) {
        this.total = total;
        this.list = list;
    }

    /**
     * 转换为 BaseResponse 结果对象
     *
     * @return {@link BaseResponse}
     */
    public BaseResponse<Page<T>> toResponse() {
        return BaseResponse.success(this);

    }


    // TODO



    /**
     * 空对象
     *
     * @param <T> 对象泛型
     * @return 空分页对象
     */
    public static <T> Page<T> empty() {
        return new Page<>(0L, Collections.emptyList());
    }


    public Long getTotal() {
        return total;
    }

    public List<T> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "Page{" +
                "total=" + total +
                ", list=" + list +
                '}';
    }
}

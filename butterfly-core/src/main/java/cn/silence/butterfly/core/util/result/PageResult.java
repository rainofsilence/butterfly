package cn.silence.butterfly.core.util.result;

import cn.silence.butterfly.core.util.BeanPlusUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/5/1 16:20
 */
public class PageResult<T> {

    /**
     * 数据总数
     */
    private final Long total;
    /**
     * 指定页数数据列表
     */
    private final List<T> list;

    public PageResult(Long total, List<T> list) {
        this.total = total;
        this.list = list;
    }

    /**
     * 转换为 BaseResponse 结果对象
     *
     * @return {@link BaseResponse}
     */
    public BaseResponse<PageResult<T>> toResponse() {
        return BaseResponse.success(this);

    }

    /**
     * 分页对象简单工厂
     *
     * @param total 总数量
     * @param data  list
     * @param <T>   对象泛型
     * @return 分页对象
     */
    public static <T> PageResult<T> with(Long total, List<T> data) {
        return new PageResult<>(total, data);
    }

    /**
     * 分页对象简单工厂，并提供List对象拷贝转换<br/>
     * 如查询出list对象为UserPO支持转换为UserVO的list
     *
     * @param total  总数量
     * @param data   list
     * @param toType 需要拷贝转换的对象的类型
     * @param <T>    对象泛型
     * @return 分页对象
     */
    public static <T> PageResult<T> with(Long total, List<?> data, Class<T> toType) {
        return with(total, BeanPlusUtils.copyProperties(data, toType));
    }

    /**
     * 空对象
     *
     * @param <T> 对象泛型
     * @return 空分页对象
     */
    public static <T> PageResult<T> empty() {
        return new PageResult<>(0L, Collections.emptyList());
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

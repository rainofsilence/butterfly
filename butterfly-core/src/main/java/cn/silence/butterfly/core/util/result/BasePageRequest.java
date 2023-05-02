package cn.silence.butterfly.core.util.result;


/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/5/1 16:33
 */
public class BasePageRequest extends BaseRequest {

    private static final long serialVersionUID = -2215892917232791462L;

    /**
     * 每页允许显示的最大记录数
     */
    public static final int MAX_PAGE_SIZE = 50;

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageQuery{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}

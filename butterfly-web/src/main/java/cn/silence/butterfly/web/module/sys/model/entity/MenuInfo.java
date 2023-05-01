package cn.silence.butterfly.web.module.sys.model.entity;

import java.io.Serializable;

/**
 * 菜单信息表
 * @TableName menu_info
 */
public class MenuInfo implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 菜单编号
     */
    private String menuNo;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 排序
     */
    private String sortNo;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 菜单编号
     */
    public String getMenuNo() {
        return menuNo;
    }

    /**
     * 菜单编号
     */
    public void setMenuNo(String menuNo) {
        this.menuNo = menuNo;
    }

    /**
     * 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 排序
     */
    public String getSortNo() {
        return sortNo;
    }

    /**
     * 排序
     */
    public void setSortNo(String sortNo) {
        this.sortNo = sortNo;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MenuInfo other = (MenuInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMenuNo() == null ? other.getMenuNo() == null : this.getMenuNo().equals(other.getMenuNo()))
            && (this.getMenuName() == null ? other.getMenuName() == null : this.getMenuName().equals(other.getMenuName()))
            && (this.getSortNo() == null ? other.getSortNo() == null : this.getSortNo().equals(other.getSortNo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMenuNo() == null) ? 0 : getMenuNo().hashCode());
        result = prime * result + ((getMenuName() == null) ? 0 : getMenuName().hashCode());
        result = prime * result + ((getSortNo() == null) ? 0 : getSortNo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", menuNo=").append(menuNo);
        sb.append(", menuName=").append(menuName);
        sb.append(", sortNo=").append(sortNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package cn.silence.butterfly.web.module.sys.model.entity;

import java.io.Serializable;

/**
 * 菜单权限表
 * @TableName menu_permission
 */
public class MenuPermission implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 菜单id
     */
    private String menuId;

    /**
     * 权限名称
     */
    private String permission;

    /**
     * 排序
     */
    private String sortNo;

    /**
     * 说明
     */
    private String remark;

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
     * 菜单id
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * 菜单id
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    /**
     * 权限名称
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 权限名称
     */
    public void setPermission(String permission) {
        this.permission = permission;
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

    /**
     * 说明
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 说明
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
        MenuPermission other = (MenuPermission) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMenuId() == null ? other.getMenuId() == null : this.getMenuId().equals(other.getMenuId()))
            && (this.getPermission() == null ? other.getPermission() == null : this.getPermission().equals(other.getPermission()))
            && (this.getSortNo() == null ? other.getSortNo() == null : this.getSortNo().equals(other.getSortNo()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMenuId() == null) ? 0 : getMenuId().hashCode());
        result = prime * result + ((getPermission() == null) ? 0 : getPermission().hashCode());
        result = prime * result + ((getSortNo() == null) ? 0 : getSortNo().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", menuId=").append(menuId);
        sb.append(", permission=").append(permission);
        sb.append(", sortNo=").append(sortNo);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
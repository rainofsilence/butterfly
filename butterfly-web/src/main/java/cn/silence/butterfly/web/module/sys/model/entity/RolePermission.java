package cn.silence.butterfly.web.module.sys.model.entity;

import java.io.Serializable;

/**
 * 角色权限表
 * @TableName role_permission
 */
public class RolePermission implements Serializable {
    /**
     * 角色id
     */
    private String roleId;

    /**
     * 菜单权限id
     */
    private String mpId;

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 角色id
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 菜单权限id
     */
    public String getMpId() {
        return mpId;
    }

    /**
     * 菜单权限id
     */
    public void setMpId(String mpId) {
        this.mpId = mpId;
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
        RolePermission other = (RolePermission) that;
        return (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getMpId() == null ? other.getMpId() == null : this.getMpId().equals(other.getMpId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getMpId() == null) ? 0 : getMpId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", mpId=").append(mpId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
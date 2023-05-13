package cn.silence.butterfly.web.module.sys.model.entity;

import java.io.Serializable;

/**
 * RolePermission.PrimaryKey
 * 
 * @author rainofsilence
 * @version v1.0.0 
 * @since 2023/05/13 14:45:25
 */
public class RolePermissionKey implements Serializable {
    /**
     * 角色id
     */
    private String roleId;

    /**
     * 菜单权限id
     */
    private String mpId;

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getMpId() {
        return mpId;
    }

    public void setMpId(String mpId) {
        this.mpId = mpId == null ? null : mpId.trim();
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
        RolePermissionKey other = (RolePermissionKey) that;
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
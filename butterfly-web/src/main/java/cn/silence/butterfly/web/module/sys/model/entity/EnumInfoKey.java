package cn.silence.butterfly.web.module.sys.model.entity;

import java.io.Serializable;

/**
 * EnumInfo.PrimaryKey
 * 
 * @author rainofsilence
 * @version v1.0.0 
 * @since 2023/05/13 20:55:09
 */
public class EnumInfoKey implements Serializable {
    /**
     *
     */
    private String id;

    public EnumInfoKey() {
    }

    public EnumInfoKey(String id) {
        this.id = id;
    }

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
        EnumInfoKey other = (EnumInfoKey) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
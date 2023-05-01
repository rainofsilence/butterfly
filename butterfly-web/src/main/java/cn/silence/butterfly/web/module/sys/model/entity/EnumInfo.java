package cn.silence.butterfly.web.module.sys.model.entity;

import java.io.Serializable;

/**
 * 枚举信息表
 * @TableName enum_info
 */
public class EnumInfo implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 枚举编号
     */
    private String enumNo;

    /**
     * 枚举名称
     */
    private String enumName;

    /**
     * 说明
     */
    private String remark;

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
     * 枚举编号
     */
    public String getEnumNo() {
        return enumNo;
    }

    /**
     * 枚举编号
     */
    public void setEnumNo(String enumNo) {
        this.enumNo = enumNo;
    }

    /**
     * 枚举名称
     */
    public String getEnumName() {
        return enumName;
    }

    /**
     * 枚举名称
     */
    public void setEnumName(String enumName) {
        this.enumName = enumName;
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
        EnumInfo other = (EnumInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEnumNo() == null ? other.getEnumNo() == null : this.getEnumNo().equals(other.getEnumNo()))
            && (this.getEnumName() == null ? other.getEnumName() == null : this.getEnumName().equals(other.getEnumName()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getSortNo() == null ? other.getSortNo() == null : this.getSortNo().equals(other.getSortNo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEnumNo() == null) ? 0 : getEnumNo().hashCode());
        result = prime * result + ((getEnumName() == null) ? 0 : getEnumName().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
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
        sb.append(", enumNo=").append(enumNo);
        sb.append(", enumName=").append(enumName);
        sb.append(", remark=").append(remark);
        sb.append(", sortNo=").append(sortNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
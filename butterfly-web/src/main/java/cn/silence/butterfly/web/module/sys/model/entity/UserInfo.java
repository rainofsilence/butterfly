package cn.silence.butterfly.web.module.sys.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息表
 * @TableName user_info
 */
public class UserInfo implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 证件类型
     */
    private String certType;

    /**
     * 证件号码
     */
    private String certId;

    /**
     * 性别
     */
    private String gender;

    /**
     * 是否启用 1:是 0:否
     */
    private Integer inuse;

    /**
     * 是否锁定 1:是 0:否
     */
    private Integer locked;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除时间
     */
    private Date deleteTime;

    /**
     * 是否删除 1:是 0:否
     */
    private Integer deleted;

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
     * 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 账号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 账号
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 证件类型
     */
    public String getCertType() {
        return certType;
    }

    /**
     * 证件类型
     */
    public void setCertType(String certType) {
        this.certType = certType;
    }

    /**
     * 证件号码
     */
    public String getCertId() {
        return certId;
    }

    /**
     * 证件号码
     */
    public void setCertId(String certId) {
        this.certId = certId;
    }

    /**
     * 性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 性别
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 是否启用 1:是 0:否
     */
    public Integer getInuse() {
        return inuse;
    }

    /**
     * 是否启用 1:是 0:否
     */
    public void setInuse(Integer inuse) {
        this.inuse = inuse;
    }

    /**
     * 是否锁定 1:是 0:否
     */
    public Integer getLocked() {
        return locked;
    }

    /**
     * 是否锁定 1:是 0:否
     */
    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 删除时间
     */
    public Date getDeleteTime() {
        return deleteTime;
    }

    /**
     * 删除时间
     */
    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    /**
     * 是否删除 1:是 0:否
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 是否删除 1:是 0:否
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
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
        UserInfo other = (UserInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getCertType() == null ? other.getCertType() == null : this.getCertType().equals(other.getCertType()))
            && (this.getCertId() == null ? other.getCertId() == null : this.getCertId().equals(other.getCertId()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getInuse() == null ? other.getInuse() == null : this.getInuse().equals(other.getInuse()))
            && (this.getLocked() == null ? other.getLocked() == null : this.getLocked().equals(other.getLocked()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getCertType() == null) ? 0 : getCertType().hashCode());
        result = prime * result + ((getCertId() == null) ? 0 : getCertId().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getInuse() == null) ? 0 : getInuse().hashCode());
        result = prime * result + ((getLocked() == null) ? 0 : getLocked().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", nickname=").append(nickname);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", realName=").append(realName);
        sb.append(", certType=").append(certType);
        sb.append(", certId=").append(certId);
        sb.append(", gender=").append(gender);
        sb.append(", inuse=").append(inuse);
        sb.append(", locked=").append(locked);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
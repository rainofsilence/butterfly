package cn.silence.butterfly.web.module.sys.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息表 user_info
 *
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/07 18:24:41
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
     * 邮箱
     */
    private String email;

    /**
     * 手机
     */
    private String phone;

    /**
     * 座机
     */
    private String landline;

    /**
     * 个性签名
     */
    private String signature;

    /**
     * 最新登录时间
     */
    private Date latestLoginTime;

    /**
     * 最新登录ip
     */
    private String latestLoginIp;

    /**
     * 是否启用 1:是 0:否
     */
    private Boolean inuse;

    /**
     * 是否锁定 1:是 0:否
     */
    private Boolean locked;

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
    private Boolean deleted;

    /**
     * user_info
     */
    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType == null ? null : certType.trim();
    }

    public String getCertId() {
        return certId;
    }

    public void setCertId(String certId) {
        this.certId = certId == null ? null : certId.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline == null ? null : landline.trim();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    public Date getLatestLoginTime() {
        return latestLoginTime;
    }

    public void setLatestLoginTime(Date latestLoginTime) {
        this.latestLoginTime = latestLoginTime;
    }

    public String getLatestLoginIp() {
        return latestLoginIp;
    }

    public void setLatestLoginIp(String latestLoginIp) {
        this.latestLoginIp = latestLoginIp == null ? null : latestLoginIp.trim();
    }

    public Boolean getInuse() {
        return inuse;
    }

    public void setInuse(Boolean inuse) {
        this.inuse = inuse;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
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
                && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
                && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
                && (this.getLandline() == null ? other.getLandline() == null : this.getLandline().equals(other.getLandline()))
                && (this.getSignature() == null ? other.getSignature() == null : this.getSignature().equals(other.getSignature()))
                && (this.getLatestLoginTime() == null ? other.getLatestLoginTime() == null : this.getLatestLoginTime().equals(other.getLatestLoginTime()))
                && (this.getLatestLoginIp() == null ? other.getLatestLoginIp() == null : this.getLatestLoginIp().equals(other.getLatestLoginIp()))
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
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getLandline() == null) ? 0 : getLandline().hashCode());
        result = prime * result + ((getSignature() == null) ? 0 : getSignature().hashCode());
        result = prime * result + ((getLatestLoginTime() == null) ? 0 : getLatestLoginTime().hashCode());
        result = prime * result + ((getLatestLoginIp() == null) ? 0 : getLatestLoginIp().hashCode());
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
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", landline=").append(landline);
        sb.append(", signature=").append(signature);
        sb.append(", latestLoginTime=").append(latestLoginTime);
        sb.append(", latestLoginIp=").append(latestLoginIp);
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
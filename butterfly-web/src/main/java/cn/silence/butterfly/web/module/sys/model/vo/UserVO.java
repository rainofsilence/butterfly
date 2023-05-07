package cn.silence.butterfly.web.module.sys.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/02 20:22:38
 */
@ApiModel(value = "UserVO", description = "UserVO")
public class UserVO implements Serializable {
    private static final long serialVersionUID = -5415470312918042837L;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("账号")
    private String username;

    @ApiModelProperty("性别码值")
    private String gender;

    @ApiModelProperty("性别")
    private String genderName;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("手机")
    private String phone;

    @ApiModelProperty("座机")
    private String landline;

    @ApiModelProperty("个性签名")
    private String signature;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", genderName='" + genderName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", landline='" + landline + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}

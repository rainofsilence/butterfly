package cn.silence.butterfly.web.module.sys.model.request;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/14 14:10:34
 */
@ApiModel(value = "UserRegister", description = "UserRegister")
public class UserRegister implements Serializable {
    private static final long serialVersionUID = -996698552781196379L;

    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("性别")
    private String gender;
    @ApiModelProperty("邮件")
    private String email;
    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("座机号")
    private String landline;
    @ApiModelProperty("个签")
    private String signature;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("确认密码")
    private String confirmPassword;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "UserRegister{" +
                "username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", landline='" + landline + '\'' +
                ", signature='" + signature + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}

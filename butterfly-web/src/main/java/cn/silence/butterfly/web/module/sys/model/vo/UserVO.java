package cn.silence.butterfly.web.module.sys.model.vo;

import java.io.Serializable;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/02 20:22:38
 */
public class UserVO implements Serializable {
    private static final long serialVersionUID = -5415470312918042837L;

    private String nickname;

    private String username;

    private String gender;

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

    @Override
    public String toString() {
        return "UserVO{" +
                "nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

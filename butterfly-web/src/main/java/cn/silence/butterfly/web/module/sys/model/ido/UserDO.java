package cn.silence.butterfly.web.module.sys.model.ido;

import java.io.Serializable;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/02 14:14:47
 */
public class UserDO implements Serializable {
    private static final long serialVersionUID = 3719741974734344895L;

    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "nickname='" + nickname + '\'' +
                '}';
    }
}

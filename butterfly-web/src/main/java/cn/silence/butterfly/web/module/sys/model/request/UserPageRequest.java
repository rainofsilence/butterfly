package cn.silence.butterfly.web.module.sys.model.request;

import cn.silence.butterfly.core.util.result.BasePageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/02 14:03:03
 */
@ApiModel(value = "UserPageRequest", description = "UserPageRequest")
public class UserPageRequest extends BasePageRequest {
    private static final long serialVersionUID = -2864857657051161175L;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "UserPageRequest{" +
                "nickname='" + nickname + '\'' +
                '}';
    }
}

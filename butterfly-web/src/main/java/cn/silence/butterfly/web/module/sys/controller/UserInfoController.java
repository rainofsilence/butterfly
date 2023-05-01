package cn.silence.butterfly.web.module.sys.controller;

import cn.silence.butterfly.core.util.result.BaseResponse;
import cn.silence.butterfly.core.util.result.Page;
import cn.silence.butterfly.web.module.sys.model.entity.UserInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/5/1 16:08
 */
@RestController
@RequestMapping("/sys/user")
public class UserInfoController {

    @PostMapping("/list")
    public BaseResponse<Page<UserInfo>> page() {
        // TODO
        return BaseResponse.success(Page.empty());
    }
}

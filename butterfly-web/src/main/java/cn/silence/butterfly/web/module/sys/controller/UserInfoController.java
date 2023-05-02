package cn.silence.butterfly.web.module.sys.controller;

import cn.silence.butterfly.core.util.result.BaseResponse;
import cn.silence.butterfly.core.util.result.PageResult;
import cn.silence.butterfly.web.module.sys.model.request.UserPageRequest;
import cn.silence.butterfly.web.module.sys.model.vo.UserVO;
import cn.silence.butterfly.web.module.sys.service.IUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/5/1 16:08
 */
@Api(tags = "用户管理模块")
@RestController
@RequestMapping("/sys/user")
public class UserInfoController {

    @Resource
    private IUserInfoService iUserInfoService;

    @ApiOperation(value = "用户管理-分页查询")
    @PostMapping("/list")
    public BaseResponse<PageResult<UserVO>> pageList(@RequestBody UserPageRequest pageRequest) {
        return iUserInfoService.pageList(pageRequest);
    }
}

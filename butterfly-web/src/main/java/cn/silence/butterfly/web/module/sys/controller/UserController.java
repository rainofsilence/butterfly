package cn.silence.butterfly.web.module.sys.controller;

import cn.silence.butterfly.core.exception.BizAssert;
import cn.silence.butterfly.core.util.result.BaseResponse;
import cn.silence.butterfly.core.util.result.PageResult;
import cn.silence.butterfly.web.module.sys.model.request.UserPageRequest;
import cn.silence.butterfly.web.module.sys.model.vo.UserVO;
import cn.silence.butterfly.web.module.sys.service.IUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/5/1 16:08
 */
@Api(tags = "User")
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Resource
    private IUserInfoService iUserInfoService;

    @ApiOperation("page")
    @PostMapping("/page")
    public BaseResponse<PageResult<UserVO>> page(@RequestBody UserPageRequest pageRequest) {
        return iUserInfoService.page(pageRequest);
    }

    @ApiOperation("get")
    @GetMapping("/{username}")
    public BaseResponse<UserVO> getOne(@PathVariable String username) {
        BizAssert.notBlank(username, "username must be not null");
        return iUserInfoService.selectOne(username);
    }

    @ApiOperation("save")
    @PostMapping("/")
    public BaseResponse<String> save(@RequestBody UserVO userVO) {
        BizAssert.notNull(userVO, "param must be not null");
        BizAssert.notBlank(userVO.getUsername(), "username must be not null");
        return iUserInfoService.insert(userVO);
    }

    @ApiOperation("update")
    @PutMapping("/")
    public BaseResponse<String> update(@RequestBody UserVO userVO) {
        BizAssert.notNull(userVO, "param must be not null");
        BizAssert.notBlank(userVO.getUsername(), "username must be not null");
        return iUserInfoService.update(userVO);
    }

    @ApiOperation("delete")
    @DeleteMapping("/{username}")
    public BaseResponse<String> delete(@PathVariable String username) {
        BizAssert.notBlank(username, "username must be not null");
        return iUserInfoService.delete(username);
    }
}

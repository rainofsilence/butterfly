package cn.silence.butterfly.web.module.sys.api;

import cn.silence.butterfly.core.util.result.BaseResponse;
import cn.silence.butterfly.web.module.sys.model.request.UserRegister;
import cn.silence.butterfly.web.module.sys.model.vo.UserVO;
import cn.silence.butterfly.web.module.sys.service.IUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/14 13:59:18
 */
@Api(tags = "User")
@RestController
@RequestMapping("/sys/user")
public class UserApi {

    @Resource
    private IUserInfoService iUserInfoService;

    @ApiOperation("user:register")
    @PostMapping("/register")
    public BaseResponse<UserVO> register(@RequestBody UserRegister userRegister, HttpServletRequest request) {
        return iUserInfoService.register(userRegister);
    }

    @ApiOperation("user:login")
    @PostMapping("/login")
    public BaseResponse<UserVO> login(@RequestParam("username") String username,
                                      @RequestParam("password") String password,
                                      HttpServletRequest request) {
        BaseResponse<UserVO> result = iUserInfoService.login(username, password);
        if (result.isSuccess()) {
            HttpSession session = request.getSession();
            session.setAttribute("userToken", result.getData());
        }
        return result;
    }

    @ApiOperation("user:isLogin")
    @GetMapping("/isLogin")
    public BaseResponse<Boolean> isLogin(HttpServletRequest request) {
        return iUserInfoService.isLogin(request.getSession());
    }

    @ApiOperation("user:logout")
    @GetMapping("/logout")
    public BaseResponse<Void> logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("userToken", null);
        return BaseResponse.success();
    }
}

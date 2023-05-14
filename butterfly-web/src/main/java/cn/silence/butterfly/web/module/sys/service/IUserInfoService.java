package cn.silence.butterfly.web.module.sys.service;

import cn.silence.butterfly.core.util.result.BaseResponse;
import cn.silence.butterfly.core.util.result.PageResult;
import cn.silence.butterfly.web.module.sys.model.request.UserPageRequest;
import cn.silence.butterfly.web.module.sys.model.request.UserRegister;
import cn.silence.butterfly.web.module.sys.model.vo.UserVO;

import javax.servlet.http.HttpSession;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/5/1 16:07
 */
public interface IUserInfoService {

    BaseResponse<PageResult<UserVO>> page(UserPageRequest pageRequest);

    BaseResponse<UserVO> selectOne(String username);

    BaseResponse<String> insert(UserVO userVO);

    BaseResponse<String> update(UserVO userVO);

    BaseResponse<String> delete(String username);

    BaseResponse<UserVO> register(UserRegister userRegister);

    BaseResponse<UserVO> login(String username, String password);

    BaseResponse<Boolean> isLogin(HttpSession httpSession);
}

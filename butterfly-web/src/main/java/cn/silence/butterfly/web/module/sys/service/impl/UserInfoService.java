package cn.silence.butterfly.web.module.sys.service.impl;

import cn.silence.butterfly.core.util.BeanPlusUtils;
import cn.silence.butterfly.core.util.result.BaseResponse;
import cn.silence.butterfly.core.util.result.PageResult;
import cn.silence.butterfly.web.module.sys.mapper.UserInfoMapper;
import cn.silence.butterfly.web.module.sys.model.entity.UserInfo;
import cn.silence.butterfly.web.module.sys.model.ido.UserDO;
import cn.silence.butterfly.web.module.sys.model.request.UserPageRequest;
import cn.silence.butterfly.web.module.sys.model.vo.UserVO;
import cn.silence.butterfly.web.module.sys.service.IUserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/5/1 16:07
 */
@Service
public class UserInfoService implements IUserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public BaseResponse<PageResult<UserVO>> pageList(UserPageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<UserInfo> userInfoList = userInfoMapper.selectByUserDO(BeanPlusUtils.copyProperties(pageRequest, UserDO.class));
        PageInfo<UserInfo> userInfoPageInfo = new PageInfo<>(userInfoList);
        return PageResult.with(userInfoPageInfo.getTotal(), userInfoList, UserVO.class).toResponse();
    }
}

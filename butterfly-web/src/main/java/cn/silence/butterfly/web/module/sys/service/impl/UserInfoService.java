package cn.silence.butterfly.web.module.sys.service.impl;

import cn.silence.butterfly.core.exception.BizException;
import cn.silence.butterfly.core.util.BeanPlusUtils;
import cn.silence.butterfly.core.util.StrUtils;
import cn.silence.butterfly.core.util.UUIDUtils;
import cn.silence.butterfly.core.util.result.BaseResponse;
import cn.silence.butterfly.core.util.result.ErrorCode;
import cn.silence.butterfly.core.util.result.PageResult;
import cn.silence.butterfly.web.module.sys.common.service.IUserCheck;
import cn.silence.butterfly.web.module.sys.mapper.UserInfoMapper;
import cn.silence.butterfly.web.module.sys.model.entity.UserInfo;
import cn.silence.butterfly.web.module.sys.model.po.UserDO;
import cn.silence.butterfly.web.module.sys.model.request.UserPageRequest;
import cn.silence.butterfly.web.module.sys.model.vo.UserVO;
import cn.silence.butterfly.web.module.sys.service.IUserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/5/1 16:07
 */
@Service
public class UserInfoService implements IUserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private IUserCheck iUserCheck;

    @Override
    public BaseResponse<PageResult<UserVO>> pageList(UserPageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<UserInfo> userInfoList = userInfoMapper.selectByUserDO(BeanPlusUtils.copyProperties(pageRequest, UserDO.class));
        PageInfo<UserInfo> userInfoPageInfo = new PageInfo<>(userInfoList);
        List<UserVO> dataList = BeanPlusUtils.copyProperties(userInfoList, UserVO.class).stream().peek(d -> {
            if (StrUtils.isNotBlank(d.getGender())) {
                // TODO 等Enum方法实现再重构
                d.setGenderName(d.getGender());
            }
        }).collect(Collectors.toList());
        return PageResult.with(userInfoPageInfo.getTotal(), dataList).toResponse();
    }

    @Override
    public BaseResponse<UserVO> getOne(String username) {
        return BaseResponse.success(BeanPlusUtils.copyProperties(userInfoMapper.selectOneByUsername(username), UserVO.class));
    }

    @Override
    public BaseResponse<String> insert(UserVO userVO) {
        String username = userVO.getUsername();
        // username不能重复
        synchronized (username.intern()) {
            if (iUserCheck.isExists(username)) {
                throw new BizException(ErrorCode.PARAM_ERROR.getCode(), "The current username already exists!");
            }
            UserInfo userInfo = BeanPlusUtils.copyProperties(userVO, UserInfo.class);
            userInfo.setId("ui" + UUIDUtils.generate32UUID());
            userInfoMapper.insertSelective(userInfo);
        }
        return BaseResponse.success("Insert success");
    }

    @Override
    public BaseResponse<String> update(UserVO userVO) {
        UserInfo record = userInfoMapper.selectOneByUsername(userVO.getUsername());
        if (record == null) {
            throw new BizException(ErrorCode.PARAM_ERROR, "The current user does not exists!");
        }
        BeanPlusUtils.copyProperties(userVO, record);
        userInfoMapper.updateByPrimaryKeySelective(record);
        return BaseResponse.success("Update success");
    }

    @Override
    public BaseResponse<String> delete(String username) {
        if (!iUserCheck.isExists(username)) {
            throw new BizException(ErrorCode.PARAM_ERROR, "The current user does not exists or has been deleted!");
        }
        userInfoMapper.deleteByUsernameLogic(username);
        return BaseResponse.success("Delete success");
    }
}

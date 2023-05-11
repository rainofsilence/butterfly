package cn.silence.butterfly.web.module.sys.common.service;

import cn.silence.butterfly.web.module.sys.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/5/11 20:55
 */
@Service
public class UserCheck implements IUserCheck {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public boolean isExists(String username) {
        if (username == null || username.length() == 0) return false;
        String id = userInfoMapper.selectIdByUsername(username);
        return id != null;
    }
}

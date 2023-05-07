package cn.silence.butterfly.web.module.sys.mapper;

import cn.silence.butterfly.web.module.sys.model.entity.UserInfo;
import cn.silence.butterfly.web.module.sys.model.po.UserDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserInfo record);

    UserInfo selectByPrimaryKey(String id);

    List<UserInfo> selectAll();

    int updateByPrimaryKey(UserInfo record);

    List<UserInfo> selectByUserDO(UserDO record);

    UserInfo selectOneByUsername(@Param("username") String username);
}
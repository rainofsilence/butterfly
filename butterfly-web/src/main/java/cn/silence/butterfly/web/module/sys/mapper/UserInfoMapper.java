package cn.silence.butterfly.web.module.sys.mapper;

import cn.silence.butterfly.web.module.sys.model.entity.UserInfo;

/**
* @author rainofsilence
* @description 针对表【user_info(用户信息表)】的数据库操作Mapper
* @createDate 2023-05-01 13:25:07
* @Entity cn.silence.butterfly.web.sys.UserInfo
*/
public interface UserInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

}

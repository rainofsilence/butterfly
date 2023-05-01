package cn.silence.butterfly.web.module.sys.mapper;

import cn.silence.butterfly.web.module.sys.model.entity.UserRole;

/**
* @author rainofsilence
* @description 针对表【user_role(用户角色表)】的数据库操作Mapper
* @createDate 2023-05-01 13:25:07
* @Entity cn.silence.butterfly.web.sys.UserRole
*/
public interface UserRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

}

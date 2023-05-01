package cn.silence.butterfly.web.module.sys.mapper;

import cn.silence.butterfly.web.module.sys.model.entity.MenuPermission;

/**
* @author rainofsilence
* @description 针对表【menu_permission(菜单权限表)】的数据库操作Mapper
* @createDate 2023-05-01 13:25:07
* @Entity cn.silence.butterfly.web.sys.MenuPermission
*/
public interface MenuPermissionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MenuPermission record);

    int insertSelective(MenuPermission record);

    MenuPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MenuPermission record);

    int updateByPrimaryKey(MenuPermission record);

}

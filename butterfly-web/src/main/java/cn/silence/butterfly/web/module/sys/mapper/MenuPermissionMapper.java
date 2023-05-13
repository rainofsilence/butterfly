package cn.silence.butterfly.web.module.sys.mapper;

import cn.silence.butterfly.web.module.sys.model.entity.MenuPermission;
import cn.silence.butterfly.web.module.sys.model.entity.MenuPermissionKey;

public interface MenuPermissionMapper {
    int deleteByPrimaryKey(MenuPermissionKey key);

    int insert(MenuPermission record);

    int insertSelective(MenuPermission record);

    MenuPermission selectByPrimaryKey(MenuPermissionKey key);

    int updateByPrimaryKeySelective(MenuPermission record);

    int updateByPrimaryKey(MenuPermission record);
}
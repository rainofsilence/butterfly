package cn.silence.butterfly.web.module.sys.mapper;

import cn.silence.butterfly.web.module.sys.model.entity.MenuInfo;
import cn.silence.butterfly.web.module.sys.model.entity.MenuInfoKey;

public interface MenuInfoMapper {
    int deleteByPrimaryKey(MenuInfoKey key);

    int insert(MenuInfo record);

    int insertSelective(MenuInfo record);

    MenuInfo selectByPrimaryKey(MenuInfoKey key);

    int updateByPrimaryKeySelective(MenuInfo record);

    int updateByPrimaryKey(MenuInfo record);
}
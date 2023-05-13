package cn.silence.butterfly.web.module.sys.mapper;

import cn.silence.butterfly.web.module.sys.model.entity.RoleInfo;
import cn.silence.butterfly.web.module.sys.model.entity.RoleInfoKey;

public interface RoleInfoMapper {
    int deleteByPrimaryKey(RoleInfoKey key);

    int insert(RoleInfo record);

    int insertSelective(RoleInfo record);

    RoleInfo selectByPrimaryKey(RoleInfoKey key);

    int updateByPrimaryKeySelective(RoleInfo record);

    int updateByPrimaryKey(RoleInfo record);
}
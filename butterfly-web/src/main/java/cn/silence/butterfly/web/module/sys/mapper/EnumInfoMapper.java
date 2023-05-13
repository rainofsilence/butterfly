package cn.silence.butterfly.web.module.sys.mapper;

import cn.silence.butterfly.web.module.sys.model.entity.EnumInfo;
import cn.silence.butterfly.web.module.sys.model.entity.EnumInfoKey;

public interface EnumInfoMapper {
    int deleteByPrimaryKey(EnumInfoKey key);

    int insert(EnumInfo record);

    int insertSelective(EnumInfo record);

    EnumInfo selectByPrimaryKey(EnumInfoKey key);

    int updateByPrimaryKeySelective(EnumInfo record);

    int updateByPrimaryKey(EnumInfo record);
}
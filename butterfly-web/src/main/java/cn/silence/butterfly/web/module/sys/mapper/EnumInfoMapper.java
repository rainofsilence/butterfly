package cn.silence.butterfly.web.module.sys.mapper;

import cn.silence.butterfly.web.module.sys.model.entity.EnumInfo;

import java.util.List;

public interface EnumInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(EnumInfo record);

    EnumInfo selectByPrimaryKey(String id);

    List<EnumInfo> selectAll();

    int updateByPrimaryKey(EnumInfo record);
}
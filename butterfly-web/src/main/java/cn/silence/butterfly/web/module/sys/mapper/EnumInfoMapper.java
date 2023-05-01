package cn.silence.butterfly.web.module.sys.mapper;

import cn.silence.butterfly.web.module.sys.model.entity.EnumInfo;

/**
* @author rainofsilence
* @description 针对表【enum_info(枚举信息表)】的数据库操作Mapper
* @createDate 2023-05-01 13:25:07
* @Entity cn.silence.butterfly.web.sys.EnumInfo
*/
public interface EnumInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(EnumInfo record);

    int insertSelective(EnumInfo record);

    EnumInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EnumInfo record);

    int updateByPrimaryKey(EnumInfo record);

}

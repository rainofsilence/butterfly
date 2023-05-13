package cn.silence.butterfly.web.module.sys.mapper;

import cn.silence.butterfly.web.module.sys.model.entity.EnumInfo;
import cn.silence.butterfly.web.module.sys.model.entity.EnumInfoKey;
import cn.silence.butterfly.web.module.sys.model.po.EnumDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EnumInfoMapper {
    int deleteByPrimaryKey(EnumInfoKey key);

    int insert(EnumInfo record);

    int insertSelective(EnumInfo record);

    EnumInfo selectByPrimaryKey(EnumInfoKey key);

    int updateByPrimaryKeySelective(EnumInfo record);

    int updateByPrimaryKey(EnumInfo record);

    List<EnumInfo> selectByEnumDO(EnumDO record);

    EnumInfo selectOneByEnumNoAndItemNo(@Param("enumNo") String enumNo, @Param("itemNo") String itemNo);

    List<EnumInfo> selectByEnumNo(@Param("enumNo") String enumNo);

    String selectIdByEnumNoAndItemNo(@Param("enumNo") String enumNo, @Param("itemNo") String itemNo);
}
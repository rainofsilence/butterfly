package cn.silence.butterfly.web.module.sys.mapper;

import cn.silence.butterfly.web.module.sys.model.entity.MenuInfo;

/**
* @author rainofsilence
* @description 针对表【menu_info(菜单信息表)】的数据库操作Mapper
* @createDate 2023-05-01 13:25:07
* @Entity cn.silence.butterfly.web.sys.MenuInfo
*/
public interface MenuInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MenuInfo record);

    int insertSelective(MenuInfo record);

    MenuInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MenuInfo record);

    int updateByPrimaryKey(MenuInfo record);

}

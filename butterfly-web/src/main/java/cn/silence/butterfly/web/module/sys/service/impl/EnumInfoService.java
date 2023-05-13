package cn.silence.butterfly.web.module.sys.service.impl;

import cn.silence.butterfly.core.exception.BizException;
import cn.silence.butterfly.core.util.BeanPlusUtils;
import cn.silence.butterfly.core.util.StrUtils;
import cn.silence.butterfly.core.util.UUIDUtils;
import cn.silence.butterfly.core.util.result.BaseResponse;
import cn.silence.butterfly.core.util.result.ErrorCode;
import cn.silence.butterfly.core.util.result.PageResult;
import cn.silence.butterfly.web.module.sys.mapper.EnumInfoMapper;
import cn.silence.butterfly.web.module.sys.model.entity.EnumInfo;
import cn.silence.butterfly.web.module.sys.model.entity.EnumInfoKey;
import cn.silence.butterfly.web.module.sys.model.po.EnumDO;
import cn.silence.butterfly.web.module.sys.model.request.EnumPageRequest;
import cn.silence.butterfly.web.module.sys.model.vo.EnumVO;
import cn.silence.butterfly.web.module.sys.service.IEnumInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/13 20:56:50
 */
@Service
public class EnumInfoService implements IEnumInfoService {

    @Resource
    private EnumInfoMapper enumInfoMapper;

    @Override
    public BaseResponse<PageResult<EnumVO>> page(EnumPageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<EnumInfo> enumInfoList = enumInfoMapper.selectByEnumDO(BeanPlusUtils.copyProperties(pageRequest, EnumDO.class));
        PageInfo<EnumInfo> enumInfoPageInfo = new PageInfo<>(enumInfoList);
        return PageResult.with(enumInfoPageInfo.getTotal(), BeanPlusUtils.copyProperties(enumInfoList, EnumVO.class)).toResponse();
    }

    @Override
    public BaseResponse<EnumVO> selectOne(String enumNo, String itemNo) {
        EnumInfo enumInfo = enumInfoMapper.selectOneByEnumNoAndItemNo(enumNo, itemNo);
        return enumInfo == null
                ? BaseResponse.dataNotFound()
                : BaseResponse.success(BeanPlusUtils.copyProperties(enumInfo, EnumVO.class));
    }

    @Override
    public BaseResponse<List<EnumVO>> selectList(String enumNo) {
        List<EnumInfo> enumInfoList = enumInfoMapper.selectByEnumNo(enumNo);
        return (enumInfoList == null || enumInfoList.size() == 0)
                ? BaseResponse.dataNotFound()
                : BaseResponse.success(BeanPlusUtils.copyProperties(enumInfoList, EnumVO.class));
    }

    @Override
    public BaseResponse<String> insert(EnumVO enumVO) {
        String enumNo = enumVO.getEnumNo();
        String itemNo = enumVO.getItemNo();
        // enumNo and enumName 不能重复
        synchronized (String.format("enum@%s%s", enumNo, itemNo).intern()) {
            String id = enumInfoMapper.selectIdByEnumNoAndItemNo(enumNo, itemNo);
            if (StrUtils.isNotBlank(id))
                throw new BizException(ErrorCode.PARAM_ERROR.getCode(), "The enum already exists!");
            EnumInfo enumInfo = BeanPlusUtils.copyProperties(enumVO, EnumInfo.class);
            enumInfo.setId("ei" + UUIDUtils.generate32UUID());
            enumInfoMapper.insertSelective(enumInfo);
        }
        return BaseResponse.success("Insert success");
    }

    @Override
    public BaseResponse<String> update(EnumVO enumVO) {
        String enumNo = enumVO.getEnumNo();
        String itemNo = enumVO.getItemNo();
        EnumInfo record = enumInfoMapper.selectOneByEnumNoAndItemNo(enumNo, itemNo);
        if (record == null) throw new BizException(ErrorCode.PARAM_ERROR.getCode(), "The enum does not exists!");
        BeanPlusUtils.copyProperties(enumVO, record);
        enumInfoMapper.updateByPrimaryKeySelective(record);
        return BaseResponse.success("Update success");
    }

    @Override
    public BaseResponse<String> delete(String enumNo, String itemNo) {
        String id = enumInfoMapper.selectIdByEnumNoAndItemNo(enumNo, itemNo);
        if (StrUtils.isBlank(id)) throw new BizException(ErrorCode.PARAM_ERROR.getCode(), "The enum does not exists!");
        enumInfoMapper.deleteByPrimaryKey(new EnumInfoKey(id));
        return BaseResponse.success("Delete success");
    }
}

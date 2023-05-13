package cn.silence.butterfly.web.module.sys.service;

import cn.silence.butterfly.core.util.result.BaseResponse;
import cn.silence.butterfly.core.util.result.PageResult;
import cn.silence.butterfly.web.module.sys.model.request.EnumPageRequest;
import cn.silence.butterfly.web.module.sys.model.vo.EnumVO;

import java.util.List;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/13 20:56:33
 */
public interface IEnumInfoService {

    BaseResponse<PageResult<EnumVO>> page(EnumPageRequest pageRequest);

    BaseResponse<EnumVO> selectOne(String enumNo, String itemNo);

    BaseResponse<List<EnumVO>> selectList(String enumNo);

    BaseResponse<String> insert(EnumVO enumVO);

    BaseResponse<String> update(EnumVO enumVO);

    BaseResponse<String> delete(String enumNo, String itemNo);

}

package cn.silence.butterfly.web.module.sys.controller;

import cn.silence.butterfly.core.exception.BizAssert;
import cn.silence.butterfly.core.util.result.BaseResponse;
import cn.silence.butterfly.core.util.result.PageResult;
import cn.silence.butterfly.web.module.sys.model.request.EnumPageRequest;
import cn.silence.butterfly.web.module.sys.model.vo.EnumVO;
import cn.silence.butterfly.web.module.sys.service.IEnumInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/13 20:29:37
 */
@Api(tags = "Enum")
@RestController
@RequestMapping("/sys/enum")
public class EnumController {

    @Resource
    private IEnumInfoService iEnumInfoService;

    @ApiOperation("page")
    @PostMapping("/page")
    public BaseResponse<PageResult<EnumVO>> page(@RequestBody EnumPageRequest pageRequest) {
        return iEnumInfoService.page(pageRequest);
    }

    @ApiOperation("get")
    @GetMapping("/get/{enumNo}/{itemNo}")
    public BaseResponse<EnumVO> selectOne(@PathVariable String enumNo, @PathVariable String itemNo) {
        BizAssert.notBlank(enumNo, "`enumNo` cannot be null");
        BizAssert.notBlank(itemNo, "`itemNo` cannot be null");
        return iEnumInfoService.selectOne(enumNo, itemNo);
    }

    @ApiOperation("listByEnumNo")
    @GetMapping("/listByEnumNo/{enumNo}")
    public BaseResponse<List<EnumVO>> selectList(@PathVariable String enumNo) {
        BizAssert.notBlank(enumNo, "`enumNo` cannot be null");
        return iEnumInfoService.selectList(enumNo);
    }

    @ApiOperation("save")
    @PostMapping("/")
    public BaseResponse<String> save(@RequestBody EnumVO enumVO) {
        BizAssert.notNull(enumVO, "`param` cannot be null");
        BizAssert.notBlank(enumVO.getEnumNo(), "`enumNo` cannot be null");
        BizAssert.notBlank(enumVO.getItemNo(), "`itemNo` cannot be null");
        return iEnumInfoService.insert(enumVO);
    }

    @ApiOperation("update")
    @PutMapping("/")
    public BaseResponse<String> update(@RequestBody EnumVO enumVO) {
        BizAssert.notNull(enumVO, "`param` cannot be null");
        BizAssert.notBlank(enumVO.getEnumNo(), "`enumNo` cannot be null");
        BizAssert.notBlank(enumVO.getItemNo(), "`itemNo` cannot be null");
        return iEnumInfoService.update(enumVO);
    }

    @ApiOperation("delete")
    @DeleteMapping("/{enumNo}/{itemNo}")
    public BaseResponse<String> delete(@PathVariable String enumNo, @PathVariable String itemNo) {
        BizAssert.notBlank(enumNo, "`enumNo` cannot be null");
        BizAssert.notBlank(itemNo, "`itemNo` cannot be null");
        return iEnumInfoService.delete(enumNo, itemNo);
    }
}

package cn.silence.butterfly.web.module.sys.api;

import cn.silence.butterfly.core.exception.BizAssert;
import cn.silence.butterfly.core.util.result.BaseResponse;
import cn.silence.butterfly.web.module.sys.common.IEnumRedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/14 0:16:12
 */
@Api(tags = "CacheEnum")
@RestController
@RequestMapping("/cache/enum")
@Slf4j
public class EnumRedisApi {

    @Resource
    private IEnumRedisService iEnumRedisService;

    @ApiOperation("cache:enum:getName")
    @GetMapping("/getName/{enumNo}/{itemNo}")
    public BaseResponse<String> getItemName(@PathVariable String enumNo, @PathVariable String itemNo) {
        log.info("EnumRedisApi.getItemName start, enumNo={}, itemNo={}", enumNo, itemNo);
        BizAssert.notBlank(enumNo, "`enumNo` cannot be null");
        BizAssert.notBlank(itemNo, "`itemNo` cannot be null");
        return BaseResponse.success(iEnumRedisService.getItemName(enumNo, itemNo));
    }
}

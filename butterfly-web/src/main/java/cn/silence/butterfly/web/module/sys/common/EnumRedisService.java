package cn.silence.butterfly.web.module.sys.common;

import cn.silence.butterfly.web.module.sys.mapper.EnumInfoMapper;
import cn.silence.butterfly.web.module.sys.model.entity.EnumInfo;
import cn.silence.butterfly.web.toolkit.redis.BflyRedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

import static cn.silence.butterfly.web.toolkit.redis.RedisConstant.GROUP_ENUM;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/14 2:45:29
 */
@Service
@Slf4j
public class EnumRedisService implements IEnumRedisService {
    @Resource
    private BflyRedisUtils bflyRedisUtils;
    @Resource
    private EnumInfoMapper enumInfoMapper;

    @Override
    public String getItemName(String enumNo, String itemNo) {
        if (bflyRedisUtils.hItemHas(GROUP_ENUM, enumNo, itemNo)) {
            return bflyRedisUtils.hItemGet(GROUP_ENUM, enumNo, itemNo).toString();
        }
        String itemName;
        EnumInfo enumInfo = enumInfoMapper.selectOneByEnumNoAndItemNo(enumNo, itemNo);
        if (enumInfo == null) itemName = "";
        else itemName = enumInfo.getItemName();
        bflyRedisUtils.hItemSet(GROUP_ENUM, enumNo, itemNo, itemName);
        bflyRedisUtils.expire(GROUP_ENUM, enumNo, TimeUnit.MILLISECONDS.convert(1L, TimeUnit.DAYS));
        return itemName;
    }
}

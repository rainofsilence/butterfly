package cn.silence.butterfly.web.toolkit.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 *
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/14 0:22:15
 */
@Component
@Slf4j
public class RedisUtils {

    @Resource(name = "redisTemplate")
    private RedisTemplate<Object, Object> redisTemplate;

    //--------------------------------------------------------------------------------------------String类型数据的放入和获取
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
        } catch (Exception e) {
            log.error("RedisUtils.set is failure, {}", e.getMessage());
            return false;
        }
        return true;
    }

    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
                return true;
            }
            set(key, value);
        } catch (Exception e) {
            log.error("RedisUtils.set is failure, {}", e.getMessage());
            return false;
        }
        return true;
    }

    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    //------------------------------------------------------------------------------------------- hash数据的放入、获取等操作
    public boolean hSet(String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
        } catch (Exception e) {
            log.error("RedisUtils.hSet is failure, {}", e.getMessage());
            return false;
        }
        return true;
    }

    public boolean hSet(String key, Map<String, Object> map, long time) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if (time > 0) {
                expire(key, time);
            }
        } catch (Exception e) {
            log.error("RedisUtils.hSet is failure, {}", e.getMessage());
            return false;
        }
        return true;
    }

    public Map<Object, Object> hGet(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    //---------------------------------------------------------------------------------------------针对hash中的指定key的操作
    public boolean hItemSet(String key, String item, Object value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
        } catch (Exception e) {
            log.error("RedisUtils.hItemSet is failure, {}", e.getMessage());
            return false;
        }
        return true;
    }

    public Object hItemGet(String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }


    public boolean hItemHas(String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    public void hItemDel(String key, Object... item) {
        redisTemplate.opsForHash().delete(key, item);
    }

    /**
     * 设置指定key缓存有效期
     *
     * @param key
     * @param time
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) redisTemplate.expire(key, time, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("RedisUtils.hItemSet is failure, {}", e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * 获取指定key的有效期
     *
     * @param key
     * @return
     */
    public long getExpire(String key) {
        Long expires = redisTemplate.getExpire(key, TimeUnit.SECONDS);
        return expires == null ? 0L : expires;
    }

    /**
     * 判断指定key在缓存中是否存在
     *
     * @param key
     * @return
     */
    public boolean hasKey(String key) {
        try {
            return Boolean.TRUE.equals(redisTemplate.hasKey(key));
        } catch (Exception e) {
            log.error("RedisUtils.hasKey is failure, {}", e.getMessage());
            return false;
        }
    }

    /**
     * 删除指定key
     *
     * @param key
     */
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
                return;
            }
            redisTemplate.delete(Arrays.asList(key));
        }
    }

}

package cn.silence.butterfly.web.toolkit.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/14 1:15:10
 */
@Component
@Slf4j
public class BflyRedisUtils extends RedisUtils implements RedisConstant {

    //------------------------------------------------------------------------------------------------------------String
    public boolean set(String module, String group, String key, Object value) {
        return super.set(String.format("%s:%s:%s", module, group, key), value);
    }

    public boolean set(String module, String group, String key, Object value, long time) {
        return super.set(String.format("%s:%s:%s", module, group, key), value, time);
    }

    public boolean set(String group, String key, Object value) {
        return super.set(String.format("%s:%s:%s", MODULE_BASE, group, key), value);
    }

    public boolean set(String group, String key, Object value, long time) {
        return super.set(String.format("%s:%s:%s", MODULE_BASE, group, key), value, time);
    }

    public Object get(String module, String group, String key) {
        return super.get(String.format("%s:%s:%s", module, group, key));
    }

    public Object get(String group, String key) {
        return super.get(String.format("%s:%s:%s", MODULE_BASE, group, key));
    }

    //--------------------------------------------------------------------------------------------------------------hash
    public boolean hSet(String module, String group, String key, Map<String, Object> map) {
        return super.hSet(String.format("%s:%s:%s", module, group, key), map);
    }

    public boolean hSet(String group, String key, Map<String, Object> map) {
        return super.hSet(String.format("%s:%s:%s", MODULE_BASE, group, key), map);
    }

    public boolean hSet(String module, String group, String key, Map<String, Object> map, long time) {
        return super.hSet(String.format("%s:%s:%s", module, group, key), map, time);
    }

    public boolean hSet(String group, String key, Map<String, Object> map, long time) {
        return super.hSet(String.format("%s:%s:%s", MODULE_BASE, group, key), map, time);
    }

    public Map<Object, Object> hGet(String module, String group, String key) {
        return super.hGet(String.format("%s:%s:%s", module, group, key));
    }

    public Map<Object, Object> hGet(String group, String key) {
        return super.hGet(String.format("%s:%s:%s", MODULE_BASE, group, key));
    }

    //----------------------------------------------------------------------------------------------------------hash_opt
    public boolean hItemSet(String module, String group, String key, String item, Object value) {
        return super.hItemSet(String.format("%s:%s:%s", module, group, key), item, value);
    }

    public boolean hItemSet(String group, String key, String item, Object value) {
        return super.hItemSet(String.format("%s:%s:%s", MODULE_BASE, group, key), item, value);
    }

    public Object hItemGet(String module, String group, String key, String item) {
        return super.hItemGet(String.format("%s:%s:%s", module, group, key), item);
    }

    public Object hItemGet(String group, String key, String item) {
        return super.hItemGet(String.format("%s:%s:%s", MODULE_BASE, group, key), item);
    }

    public boolean hItemHas(String module, String group, String key, String item) {
        return super.hItemHas(String.format("%s:%s:%s", module, group, key), item);
    }

    public boolean hItemHas(String group, String key, String item) {
        return super.hItemHas(String.format("%s:%s:%s", MODULE_BASE, group, key), item);
    }

    public void hItemDel(String module, String group, String key, Object... item) {
        super.hItemDel(String.format("%s:%s:%s", module, group, key), item);
    }

    public void hItemDel(String group, String key, Object... item) {
        super.hItemDel(String.format("%s:%s:%s", MODULE_BASE, group, key), item);
    }

    public boolean expire(String module, String group, String key, long time) {
        return super.expire(String.format("%s:%s:%s", module, group, key), time);
    }

    public boolean expire(String group, String key, long time) {
        return super.expire(String.format("%s:%s:%s", MODULE_BASE, group, key), time);
    }

    public long getExpire(String module, String group, String key) {
        return super.getExpire(String.format("%s:%s:%s", module, group, key));
    }

    public long getExpire(String group, String key) {
        return super.getExpire(String.format("%s:%s:%s", MODULE_BASE, group, key));
    }

    public boolean hasKey(String module, String group, String key) {
        return super.hasKey(String.format("%s:%s:%s", module, group, key));
    }

    public boolean hasKey(String group, String key) {
        return super.hasKey(String.format("%s:%s:%s", MODULE_BASE, group, key));
    }

    public void del(String module, String group, String... key) {
        for (String sk : key) super.del(String.format("%s:%s:%s", module, group, sk));
    }

    public void del(String group, String... key) {
        for (String sk : key) super.del(String.format("%s:%s:%s", MODULE_BASE, group, sk));
    }
}

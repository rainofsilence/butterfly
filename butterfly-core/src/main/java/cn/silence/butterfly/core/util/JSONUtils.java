package cn.silence.butterfly.core.util;


import com.alibaba.fastjson2.JSON;

import java.util.List;
import java.util.Map;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/4/21 17:13
 */
public class JSONUtils {

    private JSONUtils() {
    }

    /**
     * 将对象转为json串
     *
     * @param object 对象
     * @return json
     */
    public static String toJSONString(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * 将json字符串转为对象
     *
     * @param json  json
     * @param clazz 对象class
     * @param <T>   对象实际类型
     * @return 对象
     */
    public static <T> T parseObject(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }


    /**
     * 解析json为map
     *
     * @param json json
     * @return map
     */
    public static Map<String, Object> parse(String json) {
        return JSON.parseObject(json);
    }

    /**
     * 解析数组json串，为list对象
     *
     * @param json  json串
     * @param clazz list元素class类型
     * @param <T>
     * @return list
     */
    public static <T> List<T> parseList(String json, Class<T> clazz) {
        return JSON.parseArray(json, clazz);
    }
}

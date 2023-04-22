package cn.silence.butterfly.core.util;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/4/21 17:45
 */
class JSONUtilsTest {

    @Test
    @Tag("success")
    void parse() {
        String json = "{\"username\":\"rainofsilecne\",\"age\":18}";
        Map<String, Object> map = JSONUtils.parse(json);
        System.out.println("username=>" + map.get("username"));
        System.out.println("age=>" + map.get("age"));
    }
}
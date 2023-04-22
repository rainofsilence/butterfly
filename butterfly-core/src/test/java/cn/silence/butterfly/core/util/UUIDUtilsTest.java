package cn.silence.butterfly.core.util;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/04/18 22:59:13
 */
class UUIDUtilsTest {

    @Test
    @Tag("success")
    void generateUUIDWithPrefix() {
        String uuid = UUIDUtils.generate32UUID();
        System.out.println(uuid);
    }
}
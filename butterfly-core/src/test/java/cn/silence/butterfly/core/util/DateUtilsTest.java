package cn.silence.butterfly.core.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/04/17 23:13:20
 */
class DateUtilsTest {

    @Test
    void formatDate() {
        String dateTimeStr = DateUtils.formatDate(LocalDateTime.now(), "yyyy/MM/dd HH:mm:ss");
        System.out.println(dateTimeStr);
    }
}
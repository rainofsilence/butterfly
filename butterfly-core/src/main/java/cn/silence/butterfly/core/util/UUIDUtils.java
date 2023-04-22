package cn.silence.butterfly.core.util;

import java.util.UUID;

/**
 * UUID工具类
 *
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/04/18 22:54:53
 */
public class UUIDUtils {

    /**
     * 限制创建实例
     */
    private UUIDUtils() {
    }

    /**
     * 生成 UUID，并去除横线
     *
     * @return UUID
     */
    public static String generate32UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}

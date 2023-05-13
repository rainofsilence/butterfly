package cn.silence.butterfly.core.util;

import org.junit.jupiter.api.Test;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/12 0:08:56
 */
class SaltMD5UtilsTest {

    @Test
    void mdPasswordTest() {
        // 原密码
        String password = "123456";
        System.out.println("明文(原生)密码：" + password);
        // MD5加密后的密码
        String MD5Password = SaltMD5Utils.MD5(password);
        System.out.println("普通MD5加密密码：" + MD5Password);
        // 获取加盐后的MD5值
        String SaltPassword = SaltMD5Utils.generateSaltPassword(password);
        System.out.println("加盐后的MD密码：" + SaltPassword);
        System.out.println("加盐后的MD密码长度：" + SaltPassword.length());
        System.out.println("加盐后的密码和原生密码是否是同一字符串:" + SaltMD5Utils.verifySaltPassword(password, SaltPassword));
    }

}
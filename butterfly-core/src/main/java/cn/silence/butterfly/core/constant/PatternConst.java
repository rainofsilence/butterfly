package cn.silence.butterfly.core.constant;

/**
 * 常量.正则
 *
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/04/18 22:52:57
 */
public interface PatternConst {

    /**
     * 整数
     */
    String NUMBER = "^\\d+$";
    /**
     * 手机号正则
     */
    String MOBILE = "^1[3-9]\\d{9}$";
    /**
     * 汉字，包含〇以及（）
     */
    String CHINESE = "^[\\u4e00-\\u9fa5〇（）]+$";

    /**
     * 邮箱
     */
    String EMAIL = "^\\w+([-+./]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
}

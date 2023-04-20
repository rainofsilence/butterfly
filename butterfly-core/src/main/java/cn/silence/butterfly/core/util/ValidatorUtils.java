package cn.silence.butterfly.core.util;

import cn.silence.butterfly.core.constant.PatternConst;

import java.util.regex.Pattern;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/4/20 15:15
 */
public class ValidatorUtils {

    public static Pattern mobilePattern = Pattern.compile(PatternConst.MOBILE);

    public static Pattern emailPattern = Pattern.compile(PatternConst.EMAIL);

    private ValidatorUtils() {
    }

    public static boolean isMobile(String str) {
        if (StringUtils.isBlank(str)) return false;
        return mobilePattern.matcher(str).matches();
    }

    public static boolean isEmail(String str) {
        if (StringUtils.isBlank(str)) return false;
        return emailPattern.matcher(str).matches();
    }
}

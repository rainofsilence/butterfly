package cn.silence.butterfly.web.module.sys.common.service;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/5/11 20:58
 */
public interface IUserCheck {

    /**
     * 判断用户是否存在
     *
     * @param username
     * @return
     */
    boolean isExists(String username);
}

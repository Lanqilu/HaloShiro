package top.halo.shiro.service;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author Halo
 * @create 2021/09/24 下午 07:32
 * @description 登录服务
 */
public interface LoginService {

    /**
     * @param token 登录对象
     * @return 是否登录成功
     * @description 登录方法
     */
    boolean login(UsernamePasswordToken token);

    /**
     * @description 登出方法
     */
    void logout();
}

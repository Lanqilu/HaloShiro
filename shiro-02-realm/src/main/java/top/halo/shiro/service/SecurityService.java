package top.halo.shiro.service;

/**
 * @author Halo
 * @create 2021/09/24 下午 03:35
 * @description 模拟数据库操作服务接口
 */
public interface SecurityService {

    /**
     * @param loginName 登录名称
     * @return 该用户名对应的密码
     * @description 查找密码按用户登录名
     */
    String findPasswordByLoginName(String loginName);
}
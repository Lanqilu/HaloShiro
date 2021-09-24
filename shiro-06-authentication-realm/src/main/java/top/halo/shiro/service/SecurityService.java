package top.halo.shiro.service;

import java.util.List;
import java.util.Map;

/**
 * @author Halo
 * @create 2021/09/24 下午 03:35
 * @description 模拟数据库操作服务接口
 */
public interface SecurityService {

    /**
     * @param loginName 登录名称
     * @return 该用户名对应的密码与 salt 的 Map
     * @description 查找密码按用户登录名
     */
    Map<String, String> findPasswordByLoginName(String loginName);

    /**
     * @param loginName 登录名称
     * @return 角色字符串列表
     * @description 查找角色按用户登录名
     */
    List<String> findRoleByLoginName(String loginName);

    /**
     * @param loginName 登录名称
     * @return 资源字符串列表
     * @description 查找资源按用户登录名
     */
    List<String> findPermissionByLoginName(String loginName);
}
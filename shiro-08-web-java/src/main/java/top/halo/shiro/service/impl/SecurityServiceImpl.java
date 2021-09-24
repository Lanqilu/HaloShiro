package top.halo.shiro.service.impl;

import top.halo.shiro.service.SecurityService;
import top.halo.shiro.tools.DigestsUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Halo
 * @create 2021/09/24 下午 03:37
 * @description 模拟数据库操作服务接口实现
 */
public class SecurityServiceImpl implements SecurityService {

    @Override
    public Map<String, String> findPasswordByLoginName(String loginName) {
        return DigestsUtil.entryptPassword("123");
    }

    @Override
    public List<String> findRoleByLoginName(String loginName) {
        List<String> list = new ArrayList<>();
        if ("admin".equals(loginName)) {
            list.add("admin");
        }
        list.add("dev");
        return list;
    }

    @Override
    public List<String> findPermissionByLoginName(String loginName) {
        List<String> list = new ArrayList<>();
        if ("jay".equals(loginName)) {
            list.add("order:list");
            list.add("order:add");
            list.add("order:del");
        }
        return list;
    }
}

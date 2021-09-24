package top.halo.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import top.halo.shiro.service.impl.SecurityServiceImpl;

/**
 * @author Halo
 * @create 2021/09/24 下午 03:34
 * @description
 */
public class DefinitionRealm extends AuthorizingRealm {
    /**
     * @description 认证方法
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取登录名
        String loginName = (String) authenticationToken.getPrincipal();
        // 通过模拟数据库查询密码
        SecurityServiceImpl securityService = new SecurityServiceImpl();
        String password = securityService.findPasswordByLoginName(loginName);
        if ("".equals(password) || password == null) {
            throw new UnknownAccountException("账号不存在");
        }
        // 传递账号和密码 getName() 获取当前类名称
        return new SimpleAuthenticationInfo(loginName, password, getName());
    }


    /**
     * @description 鉴权方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}

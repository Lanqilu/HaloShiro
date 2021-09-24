package top.halo.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import top.halo.shiro.service.impl.SecurityServiceImpl;
import top.halo.shiro.tools.DigestsUtil;

import java.util.Map;

/**
 * @author Halo
 * @create 2021/09/24 下午 03:34
 * @description
 */
public class DefinitionRealm extends AuthorizingRealm {

    public DefinitionRealm() {
        // 指定密码匹配方式 SH1
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher(DigestsUtil.SHA1);
        // 指定密码迭代次数
        hashedCredentialsMatcher.setHashIterations(DigestsUtil.ITERATIONS);
        // 使用父层方法使匹配方式生效
        setCredentialsMatcher(hashedCredentialsMatcher);
    }

    /**
     * @description 认证方法
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取登录名
        String loginName = (String) authenticationToken.getPrincipal();
        // 通过模拟数据库查询密码
        SecurityServiceImpl securityService = new SecurityServiceImpl();
        Map<String, String> passwordMap = securityService.findPasswordByLoginName(loginName);
        if (passwordMap.isEmpty()) {
            throw new UnknownAccountException("账号不存在");
        }
        String salt = passwordMap.get("salt");
        String password = passwordMap.get("password");

        // 传递账号和密码 getName() 获取当前类名称
        return new SimpleAuthenticationInfo(loginName, password, ByteSource.Util.bytes(salt), getName());
    }


    /**
     * @description 鉴权方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}

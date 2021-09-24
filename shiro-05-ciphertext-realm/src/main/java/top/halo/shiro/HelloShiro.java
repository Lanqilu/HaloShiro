package top.halo.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * @author Halo
 * @create 2021/09/24 下午 03:21
 * @description 使用 Shiro
 */
public class HelloShiro {
    @Test
    public void shiroLogin() {
        // 导入权限 ini 文件构建权限工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        // 工厂构建安全管理器
        SecurityManager securityManager = factory.getInstance();
        // 使用 SecurityUtils 工具生效安全管理器
        SecurityUtils.setSecurityManager(securityManager);
        // 使用 SecurityUtils 工具获得主体
        Subject subject = SecurityUtils.getSubject();
        // 构建账号 token
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("jay", "123");
        // 登录操作
        subject.login(usernamePasswordToken);
        System.out.println("是否登录成功：" + subject.isAuthenticated());
    }
}

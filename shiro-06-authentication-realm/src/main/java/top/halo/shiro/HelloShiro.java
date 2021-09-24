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
    public void testPermissionRealm() {
        Subject subject = shiroLogin();
        // 判断用户是否已经登录
        System.out.println("是否登录成功：" + subject.isAuthenticated());

        //---------检查当前用户的角色信息------------
        System.out.println("是否有管理员角色：" + subject.hasRole("admin"));
        //---------如果当前用户有此角色，无返回值。若没有此权限，则抛 UnauthorizedException------------
        try {
            subject.checkRole("coder");
            System.out.println("有coder角色");
        } catch (Exception e) {
            System.out.println("没有coder角色");
        }

        //---------检查当前用户的权限信息------------
        System.out.println("是否有查看订单列表资源：" + subject.isPermitted("order:list"));
        //---------如果当前用户有此权限，无返回值。若没有此权限，则抛 UnauthorizedException------------
        try {
            subject.checkPermissions("order:add", "order:del");
            System.out.println("有添加和删除订单资源");
        } catch (Exception e) {
            System.out.println("没有有添加和删除订单资源");
        }
    }


    public Subject shiroLogin() {
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
        return subject;
    }


    @Test
    public void shiroLoginTest() {
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

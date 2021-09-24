package top.halo.shiro.client;

import org.junit.Test;
import top.halo.shiro.tools.EncodesUtil;

/**
 * @author Halo
 * @create 2021/09/24 下午 04:12
 * @description
 */
public class ClientTest {

    /**
     * @description 测试 16 进制编码
     */
    @Test
    public void testHex() {
        String val = "hello";
        String flag = EncodesUtil.encodeHex(val.getBytes());
        String valHandler = new String(EncodesUtil.decodeHex(flag));
        System.out.println("val = " + val);
        System.out.println("flag = " + flag);
        System.out.println("valHandler = " + valHandler);
        System.out.println("比较结果：" + val.equals(valHandler));
    }

    /**
     * @description 测试 base64 编码
     */
    @Test
    public void testBase64() {
        String val = "hello";
        String flag = EncodesUtil.encodeBase64(val.getBytes());
        String valHandler = new String(EncodesUtil.decodeBase64(flag));
        System.out.println("val = " + val);
        System.out.println("flag = " + flag);
        System.out.println("valHandler = " + valHandler);
        System.out.println("比较结果：" + val.equals(valHandler));
    }
}
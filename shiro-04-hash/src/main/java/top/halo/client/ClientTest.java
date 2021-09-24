package top.halo.client;

import org.junit.Test;
import top.halo.tools.DigestsUtil;

import java.util.Map;

/**
 * @author Halo
 * @create 2021/09/24 下午 04:36
 * @description
 */
public class ClientTest {

    /**
     * 测试 Hash 加密
     */
    @Test
    public void testDigestsUtil() {
        Map<String, String> map = DigestsUtil.entryptPassword("123");
        System.out.println("获得结果：" + map);
    }
}

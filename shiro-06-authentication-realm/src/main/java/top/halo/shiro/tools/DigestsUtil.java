package top.halo.shiro.tools;


import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Halo
 * @create 2021/09/24 下午 04:24
 * @description
 */
public class DigestsUtil {

    public static final String SHA1 = "SHA-1";

    /**
     * 加密次数
     */
    public static final Integer ITERATIONS = 512;

    /**
     * @param input 需要散列字符串
     * @param salt  干扰字符串
     * @description sha1方法
     */
    public static String sha1(String input, String salt) {
        return new SimpleHash(SHA1, input, salt, ITERATIONS).toString();
    }

    /**
     * @return hex 编码的slat
     * @description 随机生成salt字符串
     */
    public static String generateSalt() {
        SecureRandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
        return randomNumberGenerator.nextBytes().toHex();
    }


    /**
     * @param passwordPlain 明文密码
     * @description 生成密码字符密文和salt密文
     * @return map → salt, 密文密码
     */
    public static Map<String, String> entryptPassword(String passwordPlain) {
        Map<String, String> map = new HashMap<>();
        String salt = generateSalt();
        String password = sha1(passwordPlain, salt);
        map.put("salt", salt);
        map.put("password", password);
        return map;
    }
}
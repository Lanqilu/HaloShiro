package top.halo.shiro.tools;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;

/**
 * @author Halo
 * @create 2021/09/24 下午 04:10
 * @description 编码工具类
 */
public class EncodesUtil {

    /**
     * @param input 输入数组
     * @return String
     * @description HEX-byte[]--String转换
     */
    public static String encodeHex(byte[] input) {
        return Hex.encodeToString(input);
    }

    /**
     * @param input 输入字符串
     * @return byte数组
     * @description HEX-String--byte[]转换
     */
    public static byte[] decodeHex(String input) {
        return Hex.decode(input);
    }

    /**
     * @param input 输入数组
     * @return String
     * @description Base64-byte[]--String转换
     */
    public static String encodeBase64(byte[] input) {
        return Base64.encodeToString(input);
    }

    /**
     * @param input 输入字符串
     * @return byte数组
     * @description Base64-String--byte[]转换
     */
    public static byte[] decodeBase64(String input) {
        return Base64.decode(input);
    }
}

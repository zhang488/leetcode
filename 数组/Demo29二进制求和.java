package 数组;

/**
 * 67. 二进制求和
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 *
 *
 *
 * 示例 1：
 *
 * 输入:a = "11", b = "1"
 * 输出："100"
 * 示例 2：
 *
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 *
 *
 * 提示：
 *
 * 1 <= a.length, b.length <= 104
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 */
public class Demo29二进制求和 {

    public static void main(String[] args) {

    }


    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }
}

package 数组;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 *
 *
 * 示例 1:
 *
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 *
 * 输入：s = "paper", t = "title"
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s 和 t 由任意有效的 ASCII 字符组成
 */
public class Demo19同构字符串 {
    public static void main(String[] args) {
        String str="paper";
        String str1="title";
        System.out.println(isIsomorphic2(str,str1));
    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (!map.get(s.charAt(i)).equals(t.charAt(i))) {
                    return false;
                }
            }else {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }else {
                    map.put(s.charAt(i),t.charAt(i));
                }
            }
        }
        return true;
    }


    public static boolean isIsomorphic2(String s, String t){
        Map<Character,Character> s1=new HashMap<>();
        Map<Character,Character> t1=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char s1Char = s.charAt(i), t1Char = t.charAt(i);
            if (s1.containsKey(s1Char)&&s1.get(s1Char)!=t1Char||t1.containsKey(t1Char)&&t1.get(t1Char)!=s1Char) {
                return false;
            }
            s1.put(s1Char,t1Char);
            t1.put(t1Char,s1Char);
        }
        return true;
    }


}

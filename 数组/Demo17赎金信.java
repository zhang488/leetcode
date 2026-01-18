package 数组;


import java.util.HashMap;

/**
 * 383. 赎金信
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 *
 *
 * 示例 1：
 *
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 *
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 *
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote 和 magazine 由小写英文字母组成
 */
public class Demo17赎金信 {

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    /**
     * 传统hash统计
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            if (!map.containsKey(ransomNote.charAt(i))) {
                map.put(ransomNote.charAt(i), 1);
            }else {
                map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i))+1);
            }
        }
        for (int i = 0; i < magazine.length(); i++) {
            if (map.containsKey(magazine.charAt(i))) {
                map.put(magazine.charAt(i), map.get(magazine.charAt(i))-1);
            }
        }
        for (Integer value : map.values()) {
            if (value>0) {
                return false;
            }
        }
        return true;
    }

    /**
     * hash映射
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct2(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        int[] cnt = new int[26];
        for(char c:magazine.toCharArray()){
            cnt[c - 'a']++;
        }
        for(char c:ransomNote.toCharArray()){
            if(--cnt[c - 'a'] < 0){
                return false;
            }

        }
        return true;
    }


}

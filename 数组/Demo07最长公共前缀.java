package 数组;


/**
 * 14. 最长公共前缀
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 如果非空，则仅由小写英文字母组成
 */
public class Demo07最长公共前缀 {

    public static void main(String[] args) {
        String [] strs = {"flower","gflow","flight"};
        System.out.println(majorityElement(strs));
    }

    /**
     * 默认第一个元素是最长前缀，然后和后面进行匹配，每次匹配不上就就删除一位
     * 直到能匹配上才切换下一个元素，然后遍历所有的元素匹配一遍
     * @param strs
     * @return
     */
    public static String majorityElement(String[] strs) {
        if (strs.length==0) {
            return "";
        }
        String res=strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(res)!=0){
                res=res.substring(0,res.length()-1);
            }
        }
        return res;
    }




}

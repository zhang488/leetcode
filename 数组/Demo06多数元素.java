package 数组;


import java.util.HashMap;

/**
 * 169. 多数元素
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 *
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 * 输入保证数组中一定有一个多数元素。
 *
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class Demo06多数元素 {

    public static void main(String[] args) {
        int [] nums= {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }


    public static int majorityElement(int[] nums) {
        int res=nums[0];
        int count=1;
        for (int i=1;i<nums.length;i++){
            if (count==0) {
                res=nums[i];
            }
            if (res==nums[i]) {
                count++;
            }else {
                count--;
            }
        }
        return res;
    }




}

package 数组;

import java.util.HashMap;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */

public class Demo1两数之和 {
    public static void main(String[] args) {
        int [] nums= {3,2,4};
        int[] ints = twoSum2(nums, 6);
        for (int anInt : ints) {
            System.out.print(anInt+"\t");
        }
    }

    //暴力对比
    public static int[] twoSum(int[] nums, int target) {
        int [] result=new int[2];
        for (int i = 0; i < nums.length; i++) {
            for(int j=i+1;j<nums.length;j++){
                if (nums[i]+nums[j]==target) {
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
    }

    //hash表更优化解
    public static int[] twoSum2(int[] nums, int target) {
        int [] result=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                result[0]=i;
                result[1]=map.get(target-nums[i]);
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}

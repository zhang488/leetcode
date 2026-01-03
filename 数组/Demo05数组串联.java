package 数组;

import java.util.Arrays;
import java.util.List;

/**
 * 给你一个长度为 n 的整数数组 nums 。请你构建一个长度为 2n 的答案数组 ans ，数组下标 从 0 开始计数 ，对于所有 0 <= i < n 的 i ，满足下述所有要求：
 *
 * ans[i] == nums[i]
 * ans[i + n] == nums[i]
 * 具体而言，ans 由两个 nums 数组 串联 形成。
 *
 * 返回数组 ans 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,1]
 * 输出：[1,2,1,1,2,1]
 * 解释：数组 ans 按下述方式形成：
 * - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
 * - ans = [1,2,1,1,2,1]
 * 示例 2：
 *
 * 输入：nums = [1,3,2,1]
 * 输出：[1,3,2,1,1,3,2,1]
 * 解释：数组 ans 按下述方式形成：
 * - ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
 * - ans = [1,3,2,1,1,3,2,1]
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 1000
 * 1 <= nums[i] <= 1000
 */
public class Demo05数组串联 {

    public static void main(String[] args) {
        int [] nums= {1,3,2,1};
        int[] ints = getConcatenation2(nums);
        for (int anInt : ints) {
            System.out.print(anInt+"\t");
        }
    }


    public static int[] getConcatenation(int[] nums) {
        int [] result=new int[nums.length*2];
        int j=0;
        for(int i=0;i<result.length;i++){
            result[i]=nums[j];
            if(j==nums.length-1){
                j=0;
            }else{
                j++;
            }
        }
        return result;
    }

    public static int[] getConcatenation2(int[] nums) {
        int [] result=new int[nums.length*2];
        for (int i = 0; i < result.length; i++){
            result[i]=nums[(i%nums.length)];
        }
        return result;
    }

    public static int[] getConcatenation3(int[] nums) {
        int [] result=new int[nums.length*2];
        System.arraycopy(nums,0,result,0,nums.length);
        System.arraycopy(nums,0,result,nums.length,nums.length);
        return result;
    }

}



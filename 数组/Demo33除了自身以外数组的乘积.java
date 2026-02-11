package 数组;

import java.util.Arrays;

/**
 *238. 除了自身以外数组的乘积
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除了 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 *
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * 输入 保证 数组 answer[i] 在  32 位 整数范围内
 *
 *
 * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
 */
public class Demo33除了自身以外数组的乘积 {

    public static void main(String[] args) {
        int [] ints = productExceptSelf2(new int[]{1,2,3,4});
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 前后缀和
     * @param nums
     * @return
     */
    public static int [] productExceptSelf2(int [] nums){
        int len=nums.length;

        //前缀和
        int [] left=new int[len];
        //后缀树
        int [] right=new int[len];

        //左侧为0的情况没有数据，所以乘积为1，默认原值
        left[0]=1;
        for (int i = 1; i < len; i++) {
            left[i]=nums[i-1]*left[i-1];
        }

        //右侧为0的情况没有数据，所以乘积为1，默认原值
        right[len-1]=1;
        for (int i = len-2; i >=0 ; i--) {
            right[i]=nums[i+1]*right[i+1];
        }
        int [] res=new int[len];
        for (int i = 0; i < len; i++) {
            res[i]=left[i]*right[i];
        }

        return res;
    }


    /**
     * 前后缀和优化
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        // answer[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            answer[i] = answer[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= nums[i];
        }
        return answer;
    }



}

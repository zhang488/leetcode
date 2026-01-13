package 数组;

/**
 * 55. 跳跃游戏
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 */
public class Demo13跳跃游戏 {


    public static void main(String[] args) {
        int [] nums = {2,3,1,0,4};
        boolean b = canJump2(nums);
        System.out.println(b);
    }


    /**
     * 每走一步都减一，如果路途中有比自己大的就替换，最终能走到最后一个就返回true
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int count=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count==0) {
                return false;
            }else {
                count--;
                if (count<=nums[i]) {
                    count=nums[i];
                }
            }
        }
        return true;
    }

    /**
     * 倒着走，判断步数是否能走到当前位置，能的话就更新步数，效率会更高一点，因为遍历的次数会少一些
     * @param nums
     * @return
     */
    public static boolean canJump2(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = lastPos; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}

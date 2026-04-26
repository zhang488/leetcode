package 双指针;

/**
 * 283. 移动零
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * 进阶：你能尽量减少完成的操作次数吗？
 */
public class Demo283移动零 {

    public static void main(String[] args) {
        int [] num={1,2,3,0,3,0,0};
        moveZeroes(num);
    }

    /**
     * 双指针
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if (nums.length<2) return;
        int slow=0,fast=1;
        while (fast<nums.length){
            if (nums[slow]==0&&nums[fast]!=0) {
                int temp=nums[slow];
                nums[slow]=nums[fast];
                nums[fast]=temp;
                slow++;
            }
            if (nums[slow]!=0) {
                slow++;
            }
            fast++;
        }
    }

    /**
     * 校验一遍记录几个0，然后把后面的非零移动到前面，后续在根据0的个数进行补充
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        if (nums.length<2) return;
        int movc=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0) {
                movc++;
            }else {
                int temp=nums[i];
                nums[i-movc]=temp;
            }
        }
        for (int i = 0; i < movc; i++) {
            nums[nums.length-1-i]=0;
        }
    }


}

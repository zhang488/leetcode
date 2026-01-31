package 数组;

/**
 * 45. 跳跃游戏 II
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置在下标 0。
 *
 * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在索引 i 处，你可以跳转到任意 (i + j) 处：
 *
 * 0 <= j <= nums[i] 且
 * i + j < n
 * 返回到达 n - 1 的最小跳跃次数。测试用例保证可以到达 n - 1。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 *
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 n - 1
 */
public class Demo31跳跃游戏2 {

    public static void main(String[] args) {
        int [] nums = {2,3,1,1,4};
        System.out.println(jump2(nums));
    }


    /**
     * 正向贪心算法：获取总长度，然后进行循环，如果长度能到达末尾了，就将末尾的值进行更新，直到末尾值走到最后，效率较高，进行优化反向数据
     * @param nums
     * @return
     */
    public static int jump2(int[] nums) {
        int res=0,len=nums.length-1;
        if (len<=0) {
            return 0;
        }
        int end=0,maxPosition=0;
        for (int i = 0; i < len; i++) {
            maxPosition=Math.max(maxPosition,nums[i]+i);
            if (end==i) {
                res++;
                end=maxPosition;
            }
        }
        return res;
    }


    /**
     * 贪心算法：反向查找先获取总长度，然后进行循环，如果长度能到达末尾了，就将末尾的值进行更新，直到末尾值走到最后，效率较低，进行优化正向数据
     * @param nums
     * @return
     */
    public static int jump(int [] nums){
        int res=0,len=nums.length-1;
        while (len>0){
            for (int i = 0; i < len; i++) {
                if (nums[i]+i>=len) {
                    len=i;
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}

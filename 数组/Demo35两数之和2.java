package 数组;

import com.sun.deploy.uitoolkit.impl.awt.AWTDragHelper;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 代码


 测试用例
 测试用例
 测试结果
 167. 两数之和 II - 输入有序数组
 已解答
 中等
 相关标签
 premium lock icon
 相关企业
 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。

 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。

 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。

 你所设计的解决方案必须只使用常量级的额外空间。


 示例 1：

 输入：numbers = [2,7,11,15], target = 9
 输出：[1,2]
 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 示例 2：

 输入：numbers = [2,3,4], target = 6
 输出：[1,3]
 解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
 示例 3：

 输入：numbers = [-1,0], target = -1
 输出：[1,2]
 解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。


 提示：

 2 <= numbers.length <= 3 * 104
 -1000 <= numbers[i] <= 1000
 numbers 按 非递减顺序 排列
 -1000 <= target <= 1000
 仅存在一个有效答案
 */
public class Demo35两数之和2 {


    public static void main(String[] args) {
        int [] ints = twoSum3(new int[]{2,7,11,15},9);
        System.out.println(Arrays.toString(ints));
    }


    /**
     * hash 匹配，效率较低，需要外部空间
     * @param numbers
     * @param target
     * @return
     */
    public static int [] twoSum2(int [] numbers,int target){
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (indexMap.containsKey(target-numbers[i])) {
                return new int[]{indexMap.get(target-numbers[i]),i+1};
            }
            indexMap.put(numbers[i],i+1);
        }
        return new int[]{};
    }


    /**
     * 双指针
      * @param numbers
     * @param target
     * @return
     */
    public static int [] twoSum3(int [] numbers,int target){
        int left=0,right=numbers.length-1;
        while (left!=right){
            if (numbers[left]+numbers[right]==target) {
                return new int[]{left+1,right+1};
            }
            if (numbers[left]+numbers[right]>target) {
                right--;
            }else {
                left++;
            }
        }
        return new int[]{};
    }


    /**
     * 二分查找
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int low=i+1,height=numbers.length-1;
            while (low<=height){
                int middle=(low+height)/2;
                if (numbers[middle]==target-numbers[i]) {
                    return new int[]{i+1,middle+1};
                } else if (numbers[middle]>target-numbers[i]) {
                    height=middle-1;
                }else {
                    low=middle+1;
                }
            }
        }
        return new int[]{-1,-1};
    }
}

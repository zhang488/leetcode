package 数组;

import javafx.beans.binding.When;
import jdk.nashorn.internal.objects.annotations.Where;

import java.util.HashMap;

/**
 * 11. 盛最多水的容器
 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

 返回容器可以储存的最大水量。

 说明：你不能倾斜容器。
 示例 1：
 输入：[1,8,6,2,5,4,8,3,7]
 输出：49
 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

 示例 2：

 输入：height = [1,1]
 输出：1

 */

public class Demo2盛最多水的容器 {
    public static void main(String[] args) {
        int [] nums= {1,8,6,2,5,4,8,3,7};
        int result = maxArea3(nums);
        System.out.println(result);
    }

    //暴力解法超时
    public static int maxArea(int[] height) {
        int max=0;
        for (int i = 0; i < height.length; i++) {
            for(int j=i+1;j<height.length;j++){
                if (height[i]>height[j]) {
                    if(height[j]*(j-i)>max){
                        max=height[j]*(j-i);
                    }
                }else {
                    if(height[i]*(j-i)>max){
                        max=height[i]*(j-i);
                    }
                }
            }
        }
        return max;
    }

    //暴力解法优化 超时  Math数学类真的很好用
    public static int maxArea2(int[] height) {
        int max=0;
        for (int i = 0; i < height.length; i++) {
            for(int j=i+1;j<height.length;j++){
                max=Math.max(max,Math.min(height[i],height[j])*(j-i));
            }
        }
        return max;
    }

    //双指针优化 一定注意括号
    public static int maxArea3(int[] height) {
        int max=0;
        int left =0;
        int right=height.length-1;
        while (left<right){
            max=Math.max(max,Math.min(height[left],height[right])*(right-left));
            if (height[left]<height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return max;
    }

    //双指针优化 双指针优化
    public static int maxArea4(int[] height) {
        int max=0;
        int left =0;
        int right=height.length-1;
        while (left<right){
            int L=height[left];
            int R=height[right];
            max=Math.max(max,Math.min(L,R)*(right-left));
            if (L<R) {
                while (left<right&&height[left]<=L){
                    left++;
                }
            }else {
                while (left<right&&height[right]<=R){
                    right--;
                }
            }
        }
        return max;
    }
}

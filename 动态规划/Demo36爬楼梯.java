package 动态规划;

/**
 *
 代码
 测试用例
 测试用例
 测试结果
 70. 爬楼梯
 已解答
 简单
 相关标签
 premium lock icon
 相关企业
 提示
 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？



 示例 1：

 输入：n = 2
 输出：2
 解释：有两种方法可以爬到楼顶。
 1. 1 阶 + 1 阶
 2. 2 阶
 示例 2：

 输入：n = 3
 输出：3
 解释：有三种方法可以爬到楼顶。
 1. 1 阶 + 1 阶 + 1 阶
 2. 1 阶 + 2 阶
 3. 2 阶 + 1 阶
 */
public class Demo36爬楼梯 {

    public static void main(String[] args) {
        int i = new Demo36爬楼梯().climbStairs(4);
        System.out.println(i);
    }

    /**
     * 动态规划  滚动数组
     */
    public int climbStairs(int n) {
        int p=0,q=0,r=1;
        for (int i = 1; i <= n; i++) {
            p=q;
            q=r;
            r=p+q;
        }
        return r;
    }



}

package 数组;


import java.util.HashMap;

public class Demo560和为K的子数组 {

    public static void main(String[] args) {

    }

    /**
     * 暴力枚举
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count=0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end >=0; --end) {
                sum+=nums[end];
                if (sum==k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和 + 哈希表优化
     */
    public int subarraySum2(int[] nums, int k) {
        int count=0,sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if (map.containsKey(sum-k)) {
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}

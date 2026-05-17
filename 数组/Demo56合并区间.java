package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *56. 合并区间
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 示例 3：
 *
 * 输入：intervals = [[4,7],[1,4]]
 * 输出：[[1,7]]
 * 解释：区间 [1,4] 和 [4,7] 可被视为重叠区间。
 *
 *
 * 提示：
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class Demo56合并区间 {

    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (p, q) -> p[0] - q[0]); // 按照左端点从小到大排序

        List<int[]> ans = new ArrayList<>();
        for (int[] p : intervals) {
            int m = ans.size();
            if (m > 0 && p[0] <= ans.get(m - 1)[1]) { // 左端点在合并区间内，可以合并
                ans.get(m - 1)[1] = Math.max(ans.get(m - 1)[1], p[1]); // 更新合并区间的右端点
            } else { // 不相交，无法合并
                ans.add(p); // 新的合并区间
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}

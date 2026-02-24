package 分治;

import java.util.ArrayList;
import java.util.List;

/**
 *148. 排序链表
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 *
 *
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 */
public class Demo42排序链表 {

    public static void main(String[] args) {

    }

    /**
     * 暴力解法，遍历放到链表，排序，弄成链表返回
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head==null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        list.sort(Integer::compareTo);
        ListNode res=new ListNode();
        ListNode listNode = res;
        for (int i = 0; i < list.size(); i++) {
            listNode.next= new ListNode(list.get(i));
            listNode = listNode.next;
        }
        return res.next;
    }










}

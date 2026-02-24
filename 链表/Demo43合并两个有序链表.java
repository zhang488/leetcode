package 链表;

import 分治.ListNode;

/**
 * 21. 合并两个有序链表
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 *
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 */
public class Demo43合并两个有序链表 {

    public static void main(String[] args) {

    }

    /**
     * 思路：创建一个列表节点，然后进行比较，将较小的节点加入列表中，对比较完成后，将剩余的节点加入列表中，返回结果
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res=new ListNode();
        ListNode listNode=res;
        while (list1!=null&&list2!=null){
            if (list1.val<list2.val) {
                listNode.next=list1;
                list1=list1.next;
                listNode=listNode.next;
            }else {
                listNode.next=list2;
                list2=list2.next;
                listNode=listNode.next;
            }
        }
        if (list1!=null) {
            listNode.next=list1;
        }else if(list2!=null){
            listNode.next=list2;
        }
        return res.next;
    }

}

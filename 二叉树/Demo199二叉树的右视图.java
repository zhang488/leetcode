package 二叉树;


import com.sun.jmx.remote.internal.ArrayQueue;
import 数组.TreeNode;

import java.util.*;

/**
 * 199. 二叉树的右视图
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [1,2,3,null,5,null,4]
 *
 * 输出：[1,3,4]
 *
 * 解释：
 *
 *
 *
 * 示例 2：
 *
 * 输入：root = [1,2,3,4,null,null,null,5]
 *
 * 输出：[1,3,4,5]
 *
 * 解释：
 *
 *
 *
 * 示例 3：
 *
 * 输入：root = [1,null,3]
 *
 * 输出：[1,3]
 *
 * 示例 4：
 *
 * 输入：root = []
 *
 * 输出：[]
 *
 *
 *
 * 提示:
 *
 * 二叉树的节点个数的范围是 [0,100]
 * -100 <= Node.val <= 100
 */
public class Demo199二叉树的右视图 {

    public static void main(String[] args) {

    }

    /**
     * 层级遍历，通过队列的方式，每次遍历一个元素就把当前节点的左右节点都放到队列中，这样下一层节点就会在队列的末尾
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root==null) {
            return new ArrayList<>();
        }
        List<Integer> ins=new ArrayList<>();
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size(),count=0;
            while (size-->0){
                TreeNode node = queue.poll();
                if (count++==0) {
                    ins.add(node.val);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                }
                if (node.left!=null) {
                    queue.add(node.left);
                }
            }
        }
        return ins;
    }




}

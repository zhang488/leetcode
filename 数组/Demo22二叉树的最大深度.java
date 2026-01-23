package 数组;


import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个二叉树 root ，返回其最大深度。
 *
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * 示例 2：
 *
 * 输入：root = [1,null,2]
 * 输出：2
 *
 *
 * 提示：
 *
 * 树中节点的数量在 [0, 104] 区间内。
 * -100 <= Node.val <= 100
 */
public class Demo22二叉树的最大深度 {

    public static void main(String[] args) {
        //输入：root = [3,9,20,null,null,15,7]
        //输出：3
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        System.out.println(maxDepth2(treeNode));
    }

    /**
     * 深度优先搜索
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }else {
            int leftLength = maxDepth(root.left);
            int rightLength = maxDepth(root.right);
            return Math.max(leftLength, rightLength) + 1;
        }
    }

    /**
     * 广度优先搜索
     * @param root
     * @return
     */
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
package 二叉树;

import 数组.TreeNode;

/**
 * 98. 验证二叉搜索树
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 严格小于 当前节点的数。
 * 节点的右子树只包含 严格大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [2,1,3]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 *
 *
 * 提示：
 *
 * 树中节点数目范围在[1, 104] 内
 * -231 <= Node.val <= 231 - 1
 */
public class Demo98验证二叉搜索树 {

    public static void main(String[] args) {

    }

    /**
     * 递归解法：
     * 前序遍历：根左右
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        return isValidBSTRange(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBSTRange(TreeNode root,long left,long right){
        if(root==null)return true;
        Integer x=root.val;
        return left<x&&right>x&&
                isValidBSTRange(root.left,left,x)&&isValidBSTRange(root.right,x,right);
    }


    long pre =Long.MIN_VALUE;

    /**
     * 中序遍历：左根右
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if(root==null)return true;
        if (!isValidBST2(root.left)) {
            return false;
        }
        if (root.val<= pre) {
            return false;
        }
        pre=root.val;
        return isValidBST2(root.right);
    }


    /**
     * 后序遍历：左右根
     * dfs 返回子树的最小值和最大值，供上面的节点判断是否为二叉搜索树。
     * @param root
     * @return
     */
//    public boolean isValidBST3(TreeNode root) {
//
//    }




}

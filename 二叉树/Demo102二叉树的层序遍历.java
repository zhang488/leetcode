package 二叉树;

import 数组.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Demo102二叉树的层序遍历 {

    public static void main(String[] args) {

    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        levelOrderHelper(root,ans,1);
        return ans;
    }

    public void levelOrderHelper(TreeNode root,List<List<Integer>> ans,int level){
        if(root == null){
            return;
        }
        List<Integer> tempAns = new ArrayList<>();
        if(ans.size()<level){
            ans.add(tempAns);
        }
        ans.get(level-1).add(root.val);
        levelOrderHelper(root.left,ans,level+1);
        levelOrderHelper(root.right,ans,level+1);
    }


}

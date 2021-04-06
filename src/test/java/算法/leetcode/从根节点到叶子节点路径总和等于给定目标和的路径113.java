package 算法.leetcode;

import 算法.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * UTF-8
 * Created by czy  Time : 2021/4/6 16:16
 *
 * @version 1.0
 */
// 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
// 叶子节点 是指没有子节点的节点。
public class 从根节点到叶子节点路径总和等于给定目标和的路径113 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(8);
        TreeNode n3 = new TreeNode(11);
        TreeNode n4 = new TreeNode(13);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(7);
        TreeNode n7 = new TreeNode(2);
        TreeNode n8 = new TreeNode(5);
        TreeNode n9 = new TreeNode(1);
        root.left=n1;
        root.right=n2;
        n1.left = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.left = n8;
        n5.right = n9;
        new Solution().pathSum(root,12);
    }

    static class Solution{
        List<List<Integer>> lists =new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        void preoreder(TreeNode root,int targetSum){
            if (root==null) return;
            targetSum=targetSum-root.val;
            stack.push(root);
            if (root.left==null && root.right==null){
                if (targetSum==0){
                    List<Integer> list = new LinkedList<>();
                    for (TreeNode treeNode : stack) {
                        list.add(treeNode.val);
                    }
                    lists.add(list);
                }
            }
            preoreder(root.left,targetSum);
            if (!stack.isEmpty()){
                while (stack.peek()!=root){
                    stack.pop();
                    if (stack.isEmpty())break;
                }
            }
            preoreder(root.right,targetSum);
        }
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            if (root==null) return lists;
            preoreder(root,targetSum);
            return lists;
        }
    }
}

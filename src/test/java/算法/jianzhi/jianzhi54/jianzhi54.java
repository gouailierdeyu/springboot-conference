package 算法.jianzhi.jianzhi54;

/**
 * UTF-8
 * Created by czy  Time : 2020/9/29 19:58
 *
 * @version 1.0
 */
/**
 * Definition for a binary tree node.
 */
//给定一棵二叉搜索树，请找出其中第k大的节点。
//输入: root = [3,1,4,null,2], k = 1
//        3
//        / \
//        1   4
//        \
//        2
// 输出: 4
//输入: root = [5,3,6,2,4,null,null,1], k = 3
//         5
//        / \
//        3   6
//       / \
//      2  4
//     /
//     1
//输出: 4

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

class Solution {
    int val;
    int n=0;
    public void countnode(TreeNode root,int k){
        if (root==null){
            return ;
        }
        countnode(root.right,k);
        n=n+1;
        if (n==k){
            val=root.val;
            // System.out.println(val);
        }
        countnode(root.left,k);
    }
    public int kthLargest(TreeNode root, int k) {
        countnode(root,k);
        return val;
    }
}
public class jianzhi54 {
    public static void main(String[] args) {

    }
}

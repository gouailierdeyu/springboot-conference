package jianzhi.jianzhi28a201104;

import java.util.Objects;

/**
 * UTF-8
 * Created by czy  Time : 2020/11/4 17:05
 *
 * @version 1.0
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    boolean flag=true;
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return flag; //root=null时，答案为true
        compare(root.left,root.right);
        return flag;
    }

    private void compare(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode==null && rightNode==null) return ;
        if (leftNode==null || rightNode==null) {flag=false; return ;}
        if (leftNode.val!=rightNode.val){
            flag=false;
            return ;
        }
        compare(leftNode.left,rightNode.right);
        if (!flag) return;
        compare(leftNode.right,rightNode.left);
    }
}
public class jianzhi28 {
}

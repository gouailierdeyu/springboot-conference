package jianzhi; /**
 * UTF-8
 * Created by czy  Time : 2020/9/21 21:06
 *
 * @version 1.0
 */
/**
  Definition for a binary tree node.
 */

//class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
//}

class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        transNode(root);
        return root;
    }
    public void transNode(TreeNode root){
        if (root==null)
            return;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        transNode(root.left);
        transNode(root.right);
    }
}

public class jianzhi27 {
}

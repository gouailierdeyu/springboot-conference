package 算法.jianzhi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * UTF-8
 * Created by czy  Time : 2020/9/16 19:51
 *
 * @version 1.0
 */

//  Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution55 {
    List<Integer> ilist=new ArrayList<>();
    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;
        readNode(root,0);
        ilist.forEach(integer -> System.out.println(integer));
        return Collections.max(ilist);
    }

    public void readNode(TreeNode root,int n){
        if(root==null)
            return;
        n=n+1;
        if(root.left==null && root.right==null){
            ilist.add(n);
            return;
        }
        readNode(root.left,n);
        readNode(root.right,n);

    }

    public void midReadNode(TreeNode root){
        if (root==null){
            return;
        }
        midReadNode(root.left);
        System.out.println(root.val);
        midReadNode(root.right);
    }
}

public class jianzhi55I {
    public static void main(String[] args) {
        new Solution55().maxDepth(null);
    }
}

package jianzhi.jianzhi68I201116;

/**
 * UTF-8
 * Created by czy  Time : 2020/11/16 20:55
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return null;

        return getparent(root,p,q);
    }
    public TreeNode getparent(TreeNode root,TreeNode p, TreeNode q){
        if (root==null) return null;
        if ((p.val<=root.val) && (q.val>=root.val)){
            return root;
        }else if ((q.val<=root.val) && (p.val>=root.val)) {
            return root;
        }else if ((p.val<root.val) && (q.val<root.val)){
            return getparent(root.left,p,q);
        }else {
            return getparent(root.right,p,q);
        }
    }
}
public class jianzhi68I {
    public static void main(String[] args) {
        String s="32t764\0a";
        System.out.println(s.length());

    }
}

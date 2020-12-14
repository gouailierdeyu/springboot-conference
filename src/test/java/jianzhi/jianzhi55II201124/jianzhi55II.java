package jianzhi.jianzhi55II201124;



import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * UTF-8
 * Created by czy  Time : 2020/11/24 16:33
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
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        recur(root);
        return flag;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        int right = recur(root.right);
        if (Math.abs(left - right) < 2){
           return Math.max(left, right) + 1;
        }else {
            flag=false;
            return Math.max(left, right) + 1;
        }

    }
}

public class jianzhi55II {
    public static void main(String[] args) {

    }
}

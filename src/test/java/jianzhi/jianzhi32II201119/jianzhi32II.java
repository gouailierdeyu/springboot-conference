package jianzhi.jianzhi32II201119;

import java.util.ArrayList;
import java.util.List;

/**
 * UTF-8
 * Created by czy  Time : 2020/11/19 10:25
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
    boolean flag = false;
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        int depth = 0;
         getorder( depth,root,lists);
        return null;
    }
    public void getorder(int depth, TreeNode root,List<List<Integer>>lists ){
        if (root == null) {
            return;
        }
        if (lists.size() == depth) {
            lists.add(new ArrayList<>());
        }
        lists.get(depth).add(root.val);
        getorder(depth + 1, root.left,lists);
        getorder(depth + 1, root.right,lists);
    }
}
public class jianzhi32II {
    public static void main(String[] args) {

    }
}

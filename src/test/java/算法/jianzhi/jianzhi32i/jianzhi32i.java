package 算法.jianzhi.jianzhi32i;

import 算法.TreeNode;

import java.util.*;

/**
 * UTF-8
 * Created by czy  Time : 2021/4/2 21:36
 *
 * @version 1.0
 */
public class jianzhi32i {
}
class Solution {
    List<Integer> integers=new ArrayList<>();
    public int[] levelOrder(TreeNode root) {
        if (root==null) return new int[0];
        BFS(root);
        int [] ints=new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            ints[i]=integers.get(i);
        }
        return ints;
    }

    public void BFS(TreeNode root){
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode remove = queue.remove();
                integers.add(remove.val);
                if (remove.left!=null)
                    queue.add(remove.left);
                if (remove.right!=null)
                    queue.add(remove.right);

            }
        }
    }
}

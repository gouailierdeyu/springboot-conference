package 算法.jianzhi.jianzhi32II;

import 算法.TreeNode;

import java.util.*;

/**
 * UTF-8
 * Created by czy  Time : 2021/4/2 22:11
 *
 * @version 1.0
 */
public class jianzhi32II {
    public static void main(String[] args) {

    }
}
class Solution {
    List<List<Integer>> nodes=new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null) return null;
        BFS(root);
        for (int i = 1; i < nodes.size(); i=i+2) {
            List<Integer> integers = nodes.get(i);
            List<Integer> list =new LinkedList<>();
            for (int i1 = integers.size()-1; i1 >=0; i1--) {
                list.add(integers.get(i1));
            }
            nodes.remove(i);
            nodes.add(i,list);
        }
        return nodes;
    }
    public void BFS(TreeNode root){
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list=new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode remove = queue.remove();
                list.add(remove.val);
                if (remove.left!=null)
                    queue.add(remove.left);
                if (remove.right!=null)
                    queue.add(remove.right);

            }
            nodes.add(list);
        }
    }
}

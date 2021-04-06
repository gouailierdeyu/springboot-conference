package 算法;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * UTF-8
 * Created by czy  Time : 2021/4/4 20:23
 *
 * @version 1.0
 */
public class 删除树节点使得树为满二叉树 {
    public static void main(String[] args) {

    }
    static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * 你需要返回一个指针，指向root，表示删减去若干个点后，剩下的树
         * @param root TreeNode类 指向二叉树的根
         * @return TreeNode类
         */
        public TreeNode solve (TreeNode root) {
            return bfs(root);
        }
        public  TreeNode bfs(TreeNode root){
            Queue<TreeNode> TreeNodeQueue=new ArrayDeque<>();
            TreeNodeQueue.add(root);
            while (!TreeNodeQueue.isEmpty()){
                int size = TreeNodeQueue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode head = TreeNodeQueue.remove();
                    if (head.left==null||head.right==null)
                    {
                        head.left=null;
                        head.right=null;
                        continue;
                    }
                    TreeNodeQueue.add(head.left);
                    TreeNodeQueue.add(head.right);
                }
            }
            return root;
        }
    }

}

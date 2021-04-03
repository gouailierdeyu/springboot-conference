package 算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * UTF-8
 * Created by czy  Time : 2021/3/19 16:13
 *
 * @version 1.0
 */
public class 二叉树左视图 {

    static ArrayList<TreeNode> TreeNodes = new ArrayList<>();
    static Queue<TreeNode> TreeNodeQueue = new LinkedList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(7);
        root.left=n1;
        root.right=n2;
//        n1.left = n3;
//        n1.right = n4;
        n4.right = n6;
        n2.right = n5;
        if (root!=null)
            Bfs(root);
        TreeNodes.forEach(e->{
            System.out.println(e.val);
        });


    }
    public static void Bfs(TreeNode root){
        TreeNodeQueue.add(root);
        while (!TreeNodeQueue.isEmpty()){
            int size = TreeNodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = TreeNodeQueue.remove();
                if (i==0){
                    TreeNodes.add(head);
                }
                if (head.left!=null)
                        TreeNodeQueue.add(head.left);
                if (head.right!=null)
                        TreeNodeQueue.add(head.right);
            }
        }

    }
}

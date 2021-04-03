package 算法.jianzhi.jianzhi07;

import com.jhlabs.image.RotateFilter;
import 算法.TreeNode;

import java.util.HashMap;
import java.util.Stack;

/**
 * UTF-8
 * Created by czy  Time : 2021/3/31 20:21
 *
 * @version 1.0
 */
// 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
public class jianzhi07 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] preorder = new int[]{1,2,3};
        int [] inorder = new int[]{2,3,1};
        TreeNode treeNode = solution.buildTree(preorder, inorder);
        solution.preOrder(treeNode);
    }
}
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0) return null;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            int now = preorder[i];
            if (map.get(now)<map.get(stack.peek().val)){
                TreeNode node = new TreeNode(now);
                stack.peek().left=node;
                stack.push(node);
            }else if(map.get(now)>map.get(stack.peek().val)){
                TreeNode pop = stack.pop();
                if (!stack.isEmpty()){
                    while (map.get(now)<map.get(pop.val)||map.get(now)>map.get(stack.peek().val)){
                        if (stack.isEmpty())
                            break;
                        pop = stack.pop();
                        if (stack.isEmpty())
                            break;
                    }
                }
                TreeNode node = new TreeNode(now);
                pop.right = node;
                stack.push(node);

            }
        }
        return root;
    }

    public void preOrder(TreeNode root){
        if (root==null) return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
}

//        if (stack.isEmpty()){
//                TreeNode node = new TreeNode(now);
//                pop.right = node;
//                stack.push(node);
//                }else if (map.get(now)>map.get(pop.val) && map.get(now)<map.get(stack.peek().val)){
//        TreeNode node = new TreeNode(now);
//        pop.right = node;
//        stack.push(node);
//        }

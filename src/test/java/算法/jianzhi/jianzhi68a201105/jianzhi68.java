package 算法.jianzhi.jianzhi68a201105;

import java.util.LinkedList;

/**
 * UTF-8
 * Created by czy  Time : 2020/11/5 21:37
 *
 * @version 1.0
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 下面是一种方法，还是得注意什么时候添加列表，什么时候从列表中删除
 *
 * 还有一种方法
 * 对树分别做前序遍历和后序遍历，找指定节点的从根到它的路径
 * 前序遍历列表找到指定节点的子列表，
 * 后序遍历列表，从尾部找到指定节点的子列表，
 * 两个子列表的公共节点即为指定节点的路径，
 * 分别求两个指定节点的路径，再求公共部分即找到公共祖先
 *
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    LinkedList<TreeNode> que = new LinkedList<>();
    boolean flag = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        flag = false;
        gotoTarget(root, p);
        TreeNode[] treeNodes = que.toArray(new TreeNode[0]);
        que.clear();
        flag = false;
        gotoTarget(root, q);
        TreeNode[] treeNodes2 = que.toArray(new TreeNode[0]);
        int index = Math.min(treeNodes.length, treeNodes2.length);
        int i = 0;
        for (i = 0; i < index; i++) {
            if (treeNodes[i] != treeNodes2[i])
                break;
        }
        return treeNodes2[i - 1];
    }

    public void gotoTarget(TreeNode root, TreeNode p) {
        if (root == null) return;
        que.add(root);
        if (root.val == p.val) {
            flag = true;
            return;
        }
        gotoTarget(root.left, p);
        if (!flag) {
            gotoTarget(root.right, p);
            if (!flag)
                que.removeLast();
        }
    }
}

public class jianzhi68 {
    public static void main(String[] args) {

    }
}

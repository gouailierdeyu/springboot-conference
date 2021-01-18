package jianzhi.jianzhi36a201226;

import java.util.ArrayList;
import java.util.List;

/**
 * UTF-8
 * Created by czy  Time : 2020/12/26 16:50
 *
 * @version 1.0
 */
/*
// Definition for a Node.
*/
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

class Solution {
    List<Node> nodeList = new ArrayList<>();
    public Node treeToDoublyList(Node root) {
        if(root == null ) return root; // 每次都要注意特殊情况
        if(root.right == null && root.left == null){ // 每次都要注意特殊情况
            root.right = root;
            root.left = root;
            return root; // 每次都要注意特殊情况
        }
        midsearch(root);
        nodeList.forEach((e)->System.out.println(e.val));
        Node head = nodeList.get(0);
        Node tail = nodeList.get(nodeList.size()-1);
        head.right = tail;
        head.left = tail;
        tail.left = head;
        tail.right = head;
        Node tmp = head;
        for (int i = 1; i < nodeList.size()-1; i++) {
            Node el = nodeList.get(i);
            el.right = tail;
            tail.left = el;
            tmp.right = el;
            el.left = tmp;
            tmp = el;
        }
        return head;
    }

    private void midsearch(Node root) {
        if (root==null) return ;
        midsearch(root.left);
        nodeList.add(root);
        midsearch(root.right);
    }
}
public class jianzhi36a201226 {
    public static void main(String[] args) {

    }
}

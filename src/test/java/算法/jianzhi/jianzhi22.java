package 算法.jianzhi;

/**
 * UTF-8
 * Created by czy  Time : 2020/9/17 20:09
 *
 * @version 1.0
 */

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

class Solution22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head==null){
            return null;
        }
        int count=1;
        ListNode temp=head;
        while (temp.next!=null){
            temp=temp.next;
            count++;
        }
        temp=head;
        for (int i=0;i<count-k;i++){
            temp=temp.next;
        }
        return temp;
    }

    /**
     * 使用两个指针一次遍历，
     * 第一个指针从头先走k步，然后第二个指针再从头开始走，所以两个指针距离差为 k .
     * 当第一个指针到列表尾部，第二个指针就到了倒数第k个位置。
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        if (head==null){
            return null;
        }
        int count=1;
        ListNode temp=head;
        while (temp.next!=null){
            temp=temp.next;
            count++;
        }
        temp=head;
        for (int i=0;i<count-k;i++){
            temp=temp.next;
        }
        return temp;
    }
}

public class jianzhi22 {
    public static void main(String[] args) {

    }
}

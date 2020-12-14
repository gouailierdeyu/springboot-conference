package jianzhi.jianzhi24;

/**
 * UTF-8
 * Created by czy  Time : 2020/9/27 20:12
 *
 * @version 1.0
 */
/**
 * Definition for singly-linked list.
 *  */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head==null) return null;
        ListNode temp=new ListNode(head.val);
        temp.next=null;
        head=head.next;
        while (head!=null){
            ListNode temp3=new ListNode(0);
            temp3.val=head.val;
            temp3.next=temp;
            temp=temp3;
            head=head.next;
        }
        return temp;
    }
}
public class jianzhi24 {
}

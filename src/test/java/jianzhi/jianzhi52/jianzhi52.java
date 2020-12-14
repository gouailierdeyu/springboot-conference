package jianzhi.jianzhi52;

/**
 * UTF-8
 * Created by czy  Time : 2020/9/22 23:50
 *
 * @version 1.0
 */
/**
 * Definition for singly-linked list.
 *
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp=headB;
        while (headA!=null){
            while (headB!=null){
                if (headA==headB){
                    return headA;
                }else {
                    headB=headB.next;
                }
            }
            headA=headA.next;
            headB=temp;
        }
      return null;
    }
    public ListNode getIntersectionNodeUseTwoPointer(ListNode headA, ListNode headB) {
        ListNode temp=headB;
        ListNode temp2=headA;
        while (true){
            if (headA==headB)
                return headA;
            headA=headA.next;
            headB=headB.next;
            if ((headA ==null) && (headB == null)){
                return null;
            }
            if (headA==null){
                headA=temp;
            }
            if (headB==null){
                headB=temp2;
            }

        }

    }
}
public class jianzhi52 {
}

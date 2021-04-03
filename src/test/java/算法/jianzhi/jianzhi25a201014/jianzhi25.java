package 算法.jianzhi.jianzhi25a201014;

/**
 * UTF-8
 * Created by czy  Time : 2020/10/14 16:28
 *
 * @version 1.0
 */
/**输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * Definition for singly-linked list.
 * 执行用时：1 ms, 在所有 Java 提交中击败了99.65%的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了99.01%的用户
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null ) return l2;
        if(l2==null) return l1;
        ListNode forward1=l1;
        ListNode forward2=l2;
        ListNode l3=null;
        if (forward1.val<=forward2.val){
            l3=new ListNode(forward1.val);
            forward1=l1.next;
        }else {
            l3=new ListNode(forward2.val);
            forward2=l2.next;
        }
        ListNode temp=l3;
        while (forward1!=null){
            if (forward2!=null)
            {
                if (forward1.val<=forward2.val){
                    temp.next= new ListNode(forward1.val);
                    temp=temp.next;
                    forward1=forward1.next;
                }else {
                    temp.next= new ListNode(forward2.val);
                    temp=temp.next;
                    forward2=forward2.next;
                }
            }else {
                temp.next=forward1;
                break;
            }
        }
        if (forward2!=null)
            temp.next=forward2;
        return l3;
    }
}
public class jianzhi25 {
    public static void main(String[] args) {
            ListNode l1=new ListNode(1);
            ListNode l12=l1.next=new ListNode(2);
            l12.next=new ListNode(4);
            ListNode l2=new ListNode(1);
            ListNode l22=l2.next=new ListNode(3);
            l22.next=new ListNode(4);
            new Solution().mergeTwoLists(l1,l2);

    }
}

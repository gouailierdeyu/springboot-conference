package jianzhi.jianzhi06;

/**
 * UTF-8
 * Created by czy  Time : 2020/9/25 20:44
 *
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Definition for singly-linked list.
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {
    public int[] reversePrint(ListNode head) {
        List<Integer> list=new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        Collections.reverse(list);
       return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    //下面的这个方法效果居然比上面的方法的效果好   ？？？？
    public int[] reversePrint2(ListNode head) {
        int len=0;

        while (head!=null){
            len++;
            head=head.next;
        }
        int [] list=new int[len];
        for(int i=len-1;i>=0;i--){
            if (head!=null){
                list[i]=head.val;
            }
            head=head.next;
        }

        return list;
    }
}
public class jianzhi06 {
}

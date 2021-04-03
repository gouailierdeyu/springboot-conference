package 算法.jianzhi.jianzhi09a201027;

import java.util.Stack;

/**
 * UTF-8
 * Created by czy  Time : 2020/10/27 20:08
 *
 * @version 1.0
 */
class CQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public CQueue() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack1.empty()&&stack2.empty()) return -1;
        if (stack2.empty()){
            while (!stack1.empty())
                stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
public class jianzhi09 {
    public static void main(String[] args) {
        CQueue queue=new CQueue();
        queue.appendTail(2);
        queue.appendTail(3);
        queue.appendTail(4);
        System.out.println(queue.deleteHead());
    }
}

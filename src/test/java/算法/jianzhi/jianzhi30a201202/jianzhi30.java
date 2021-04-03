package 算法.jianzhi.jianzhi30a201202;

import java.util.*;

/**
 * UTF-8
 * Created by czy  Time : 2020/12/2 21:16
 *
 * @version 1.0
 */
class MinStack {

    private Deque<Integer> stack ;
    private Deque<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<Integer>();
        minStack= new ArrayDeque<>();

    }

    public void push(int x) {
        if (stack.isEmpty()){
            minStack.push(x);
        }else {
            int i=minStack.getFirst();
            if (i>x)
                minStack.push(x);
            else
                minStack.push(i);
        }
        stack.push(x);


    }

    public void pop() {
        Integer s= stack.pop();
        Integer i=minStack.pop();
    }

    public int top() {
        return  stack.getFirst();
    }

    public int min() {
        return minStack.getFirst();
    }
}
public class jianzhi30 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }
}

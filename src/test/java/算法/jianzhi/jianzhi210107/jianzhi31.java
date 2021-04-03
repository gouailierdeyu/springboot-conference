package 算法.jianzhi.jianzhi210107;

import java.util.Stack;

/**
 *
 * UTF-8
 * Created by czy  Time : 2021/1/7 20:33
 *
 * @version 1.0
 */
// 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
// 假设压入栈的所有数字均不相等。
// 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
// 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
//    输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//    输出：true
//    解释：我们可以按以下顺序执行：
//    push(1), push(2), push(3), push(4), pop() -> 4,
//            push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

public class jianzhi31 {
    public static void main(String[] args) {
        boolean b = new Solution().validateStackSequences(new int[]{1, 2, 3,4,5}, new int[]{4,3,5,1,2});
        System.out.println(b);
    }
}

class Solution {
    Stack<Integer> stack=new Stack<>();
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed==null || pushed.length==0) return false;
        int j=0;
        for (int i = 0; i < popped.length; i++) {
            if (!stack.empty() && stack.peek()==popped[i]){
                stack.pop();
            }
            else {
                while (j<pushed.length && popped[i]!=pushed[j]  ){
                    stack.push(pushed[j]);
                    j++;
                }
                j++;
            }
        }
        return stack.empty();
    }
}

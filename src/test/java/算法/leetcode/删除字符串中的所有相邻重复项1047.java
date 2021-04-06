package 算法.leetcode;

import java.util.Stack;

/**
 * UTF-8
 * Created by czy  Time : 2021/4/5 11:36
 *
 * @version 1.0
 */
public class 删除字符串中的所有相邻重复项1047 {
    public static void main(String[] args) {
        String s = new Solution().removeDuplicates("asdhuiahs");
        System.out.println(s);
    }
}
class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack=new Stack<>();
        stack.push(S.charAt(0));
        for (int i = 1; i < S.length(); i++) {
            char c=S.charAt(i);
            if (!stack.isEmpty() && c==stack.peek()){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (Character character : stack) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}

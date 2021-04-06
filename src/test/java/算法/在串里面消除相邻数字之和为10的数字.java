package 算法;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

/**
 * UTF-8
 * Created by czy  Time : 2021/4/4 20:46
 *
 * @version 1.0
 */
public class 在串里面消除相邻数字之和为10的数字 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String str = in.next();
        int count = 0;
        Stack<Character> stack=new Stack<>();
        stack.push(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            char c=str.charAt(i);
            if (!stack.isEmpty() && c-'0'+stack.peek()-'0'==10){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (Character character : stack) {
            stringBuilder.append(character);
        }
        System.out.println(stack.size());
        System.out.println(stringBuilder);
    }
}
//7
//        2134314

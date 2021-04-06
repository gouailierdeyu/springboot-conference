package 算法;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * UTF-8
 * Created by czy  Time : 2021/4/3 16:37
 *
 * @version 1.0
 */
public class 括号匹配 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String next = in.next();
        char [] str=next.toCharArray();
        in.close();
        Stack<Character> stack=new Stack<>();
        boolean tozero=false; // 括号匹配栈中左括号为0
        boolean daxiao=true; // 必须满足大括号嵌套中括号嵌套小括号
        for (int i=0;i<str.length;i++){
            char c = str[i];
            if(stack.isEmpty() && (c=='{'||c=='['||c=='(')){
                stack.push(c);
            }else if(!stack.isEmpty() && ((c=='{'&& stack.peek()=='{')||(c=='['&& (stack.peek()=='['||stack.peek()=='{')
                    ||(c=='('&&(stack.peek()=='['||stack.peek()=='('||stack.peek()=='{'))))){
                stack.push(c);
            }else if (!stack.isEmpty()&&((c=='}'&& stack.peek()=='{')||(c==']'&&stack.peek()=='[')||(c==')'&& stack.peek()=='('))){
                stack.pop();
            }else
                daxiao=false;
        }
        if (stack.isEmpty()&&daxiao)
            tozero=true;

        System.out.println(tozero);
    }
}

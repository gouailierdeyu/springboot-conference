package 算法.jianzhi.jianzhi10IIa201102;

/**
 * UTF-8
 * Created by czy  Time : 2020/11/2 15:55
 *
 * @version 1.0
 */



/**
 * 斐波那契形式二
 * 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
class Solution {
    public int numWays(int n) {
        int fn=1;if (n==0) return 0;
        int fn1=1;if (n==1) return 1;
        for (int i=1;i<n;i++){
            int temp=Math.floorMod(fn+fn1,1000000007);
            fn=fn1;
            fn1=temp;
        }
        return fn1;
    }
}
public class jianzhi10II {
    public static void main(String[] args) {
        for (String s: args){
            System.out.println(s);
        }
        System.out.println( new Solution().numWays(7));
    }
}

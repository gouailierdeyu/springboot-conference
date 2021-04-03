package 算法.jianzhi.jianzhi10Ia201101;

/**
 * UTF-8
 * Created by czy  Time : 2020/11/1 11:02
 *
 * @version 1.0
 */
/**
 * 斐波那契形式一
 */
class Solution {
    public int fib(int n) {
        int fn=0;if (n==0) return 0;
        int fn1=1;if (n==1) return 1;
        for (int i=1;i<n;i++){
            int temp=Math.floorMod(fn+fn1,1000000007);
            fn=fn1;
            fn1=temp;
        }

        return fn1;
    }
}
public class jianzhi10I {
    public static void main(String[] args) {

    }
}

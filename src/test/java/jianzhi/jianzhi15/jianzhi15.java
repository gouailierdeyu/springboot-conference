package jianzhi.jianzhi15;

/**
 * UTF-8
 * Created by czy  Time : 2020/10/22 21:36
 *
 * @version 1.0
 */
//请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
//例如，把 9 表示成二进制是 1001，有 2 位是 1。
//因此，如果输入 9，则该函数输出 2。

class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        if (n>=0){
            while (n!=0){
                int i=n%2;
                n=n/2;
                if (i==1)
                    count++;
            }}
        else {
            n=(int)((long)(Math.pow(2,31))+n);
            while (n!=0){
                int i=n%2;
                n=n/2;
                if (i==1)
                    count++;
            }
            count++;
        }
         Integer.bitCount(n);//解法
        return count;

    }
}
public class jianzhi15 {
    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(-7));
    }
}

package 算法.jianzhi.jianzhi17;

/**
 * UTF-8
 * Created by czy  Time : 2020/9/23 21:35
 *
 * @version 1.0
 */
class Solution {
    public int[] printNumbers(int n) {
        int maxnum=(int)Math.pow(10,n)-1;
        int[] a =new int[maxnum];
        for (int i=1;i<Math.pow(10,n);i++){
            a[i-1]=i;
        }
        return a;
    }
}
public class jianzhi17 {
}

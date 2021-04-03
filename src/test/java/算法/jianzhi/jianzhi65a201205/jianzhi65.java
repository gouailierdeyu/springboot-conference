package 算法.jianzhi.jianzhi65a201205;

/**
 * UTF-8
 * Created by czy  Time : 2020/12/4 11:14
 *
 * @version 1.0
 */
class Solution {
    public int add(int a, int b) {
        int r=0;
        for (int i=31;i>=0;i--){
            int x=a<<i>>>i;
            int y=b<<i>>>i;
            int m=addcompute(x,y);
            m=m<<(31-i);
            int t=r;
            for (int j=31;j>=0;j--){
                int q=r<<j>>>j;
                int w=m<<j>>>j;
                t=addcompute(q,w);
                t=t<<(31-j);
            }
        }
        return a+b;
    }
    public int addcompute(int a,int b){
        int r=0;
        if ((a&b) ==1){
            r=1<<1;
        }else if ((a|b)==1){
            r=1;
        }else {
            r=0;
        }
        return r;
    }
}
public class jianzhi65 {
    public static void main(String[] args) {
        int a=1;
        System.out.println(a<<31>>>31);
    }
}

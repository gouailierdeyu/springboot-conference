package 算法.jianzhi;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * UTF-8
 * Created by czy  Time : 2021/4/7 11:07
 *
 * @version 1.0
 */
public class jianzhi14I剪绳子 {
    public static void main(String[] args) {
        new Solution().cuttingRope(10);
    }

    static class Solution {
        public int cuttingRope(int n) {
            int [] dp = new int[n/2];
            for (int i = 2; i < n/2+2; i++) {
                dp[i-2] = multi(n, i);
            }
            return Arrays.stream(dp).max().getAsInt();

        }
        public int multi(int n,int i){
            if (i==2) return n/2*(n-n/2);
            return n/i*multi(n-n/i,i-1);
        }
    }
}

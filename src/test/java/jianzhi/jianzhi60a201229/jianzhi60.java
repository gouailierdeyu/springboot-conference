package jianzhi.jianzhi60a201229;

import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;

/**
 * UTF-8
 * Created by czy  Time : 2020/12/29 16:12
 *
 * @version 1.0
 */
// 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。

class Solution {
    public double[] dicesProbability(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        for(int i = 1; i <= 6; i++)
            dp[1][i] = 1;

        for(int i = 2; i <= n; i++)
            for(int j = i; j <= 6 * i; j++)
                for(int k = 1; k <= 6 && k <= j; k++)
                    dp[i][j] += dp[i-1][j - k];

        double[] ans = new double[6 * n - n + 1];
        for(int i = n; i <= 6 * n; i++)
            ans[i - n] = ((double)dp[n][i]) / (Math.pow(6,n));
        return ans;
    }
}
public class jianzhi60 {
    public static void main(String[] args) {
        new Solution().dicesProbability(2);
//        System.out.println((float)1/3);

    }
}

package 算法.jianzhi.jianzhi59Ia201214;

import java.util.Arrays;

/**
 * UTF-8
 * Created by czy  Time : 2020/12/14 17:14
 *
 * @version 1.0
 */
/*
给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int [] maxs = new int[nums.length-k+1];
        for (int i=k-1,j=0;i< nums.length;i++){
            maxs[j]=findMax(nums,j,i);
            j++;
        }
        return maxs;

    }
    private int findMax(int [] nums ,int l,int r){
        int max=nums[l];
        for (int i=l+1;i<=r;i++){
            if (nums[i]>max)
                max=nums[i];
        }
        return max;
    }
}
public class jianzhi59I {
    public static void main(String[] args) {
        int [] maxs = new Solution().maxSlidingWindow(new int[]{10,9,8,7,6,5,4,3},3);
        Arrays.stream(maxs).forEach(System.out::print);
    }
}

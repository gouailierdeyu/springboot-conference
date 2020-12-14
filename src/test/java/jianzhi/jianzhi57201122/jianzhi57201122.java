package jianzhi.jianzhi57201122;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * UTF-8
 * Created by czy  Time : 2020/11/22 21:49
 *
 * @version 1.0
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i=0;i<nums.length;i++){
            int one=nums[i];
            int two=target-nums[i];
            boolean test = binarysearch(i+1,nums.length,nums,two);
            if (test) return new int[]{one,two};
        }
        return null;
    }
    public boolean binarysearch(int begin,int end,int[] nums,int target){
        int mid=begin+(end-begin)/2;
        while (begin<=end){
            if (nums[mid]==target) return true;
            else if(nums[mid]>target) end=mid-1;
            else if (nums[mid]<target) begin=mid+1;
            mid=begin+(end-begin)/2;
        }
        return false;
    }
}
public class jianzhi57201122 {
    public static void main(String[] args) {
        int [] s=   new Solution().twoSum(new int[]{1,2},2);
        Arrays.stream(s).forEach((x)-> System.out.println(x));

    }
}

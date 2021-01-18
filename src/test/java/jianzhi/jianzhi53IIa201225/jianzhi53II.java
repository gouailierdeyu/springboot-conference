package jianzhi.jianzhi53IIa201225;



/**
 * UTF-8
 * Created by czy  Time : 2020/12/25 15:40
 *
 * @version 1.0
 */
// 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
// 并且每个数字都在范围0～n-1之内。在
// 范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
// 二分查找
class Solution {
    public int missingNumber(int[] nums) {
        int left = 1,right=nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (mid==0 && nums[mid]==mid+1) return 0;
            else if (nums[mid]==mid) left=mid+1;
            else if (nums[mid]==mid+1 && nums[mid-1]==mid-1) return mid;
            else if (nums[mid]==mid+1) right=mid-1;
        }
        return nums.length;
    }
}
public class jianzhi53II {
    public static void main(String[] args) {

    }
}

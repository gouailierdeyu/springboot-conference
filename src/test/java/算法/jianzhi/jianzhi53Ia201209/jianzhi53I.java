package 算法.jianzhi.jianzhi53Ia201209;

/**
 * UTF-8
 * Created by czy  Time : 2020/12/9 20:36
 *
 * @version 1.0
 */
class Solution {
//    顺序查找
    public int search(int[] nums, int target) {
        int count=0;
        if (nums==null) return 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            } else if (num > target) {
                break;
            }
        }

        return count;
    }
    public int leftBinarySearch(int []nums,int target){
        int left=0,right= nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]<=target) left=mid+1;
            else right=mid-1;
        }
        if (nums[left-1]!=target) return -1;


        return left-1;
    }
}
public class jianzhi53I {
    public static void main(String[] args) {
        int x= new Solution().leftBinarySearch(new int[]{0,1,1,4,4,4,5,6},4);
        System.out.println(x);
    }
}

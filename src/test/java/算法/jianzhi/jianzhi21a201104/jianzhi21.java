package 算法.jianzhi.jianzhi21a201104;

/**
 * UTF-8
 * Created by czy  Time : 2020/11/4 16:32
 *
 * @version 1.0
 */
//  调整数组顺序使奇数位于偶数前面
// 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
// 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
class Solution {
    //双指针方式，首尾靠近，注意左边++,右边--可能会错过，所以判断条件是小于
    public int[] exchange(int[] nums) {
        int lindex=0;
        int rindex=nums.length-1;
        while (lindex<rindex){
            if ((nums[lindex]&1)!=1){
                if ((nums[rindex]&1)==1){
                    int temp=nums[lindex];
                    nums[lindex]=nums[rindex];
                    nums[rindex]=temp;
                    lindex++;
                    rindex--;
                }else {
                    rindex--;
                }
            }else {
                lindex++;
            }
        }
        return nums;
    }
}
public class jianzhi21 {
    public static void main(String[] args) {
    int [] nums= new Solution().exchange(new int[]{1,5,9,8,3,5,6,2,1,7});
    for(int num:nums)
        System.out.print(num+" ");
    }
}

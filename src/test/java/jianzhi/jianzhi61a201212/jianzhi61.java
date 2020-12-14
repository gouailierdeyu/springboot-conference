package jianzhi.jianzhi61a201212;

import java.util.Arrays;

/**
 * UTF-8
 * Created by czy  Time : 2020/12/12 21:03
 *
 * @version 1.0
 */
/*
从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。
A 不能视为 14。
*/
class Solution {
    public boolean isStraight(int[] nums) {
        for (int i=0;i<nums.length;i++){
            int j=i;
            for (;j>0;j--){
                if(nums[j]<nums[j-1]){
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }else break;
            }
        }
        int flag=nums[0];
        for (int i=1;i<nums.length;i++){
            if (nums[i]==flag && flag!=0)
                return false;
            else flag=nums[i];
        }
        int zero=0;
        int first = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0)
                zero++;
            else {
                first = nums[i];
                break;
            }
        }
        return nums[nums.length - 1] - first <= 4;
    }
}
public class jianzhi61 {
    public static void main(String[] args) {
        boolean straight=new Solution().isStraight(new int[]{0,9,10,0,13});
        System.out.println(straight);
    }
}

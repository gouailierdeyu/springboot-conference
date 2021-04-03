package 算法.jianzhi.jianzhi39201120;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * UTF-8
 * Created by czy  Time : 2020/11/21 15:57
 *
 * @version 1.0
 */

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * 意思是   找到数中的众数，
 * 对 数组排序，那么中间这个数一定是众数。
 */
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
           if( map.containsKey(nums[i])){
               map.put(nums[i],map.get(nums[i])+1);
           }else {
               map.put(nums[i],1);
           }
        }
        final int[] num = {0};
        Set<Integer> keySet = map.keySet();
        for (Integer i:keySet){
            if (map.get(i)>=(nums.length/2+1)) {
                num[0] = i;
                break;
            }
        }
        map.forEach((k,v)->{
            if (v>=(nums.length/2+1))
                num[0] =k;
        });
        return num[0];
    }
}
public class jianzhi39 {
    public static void main(String[] args) {

    }
}

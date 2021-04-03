package 算法.jianzhi.jianzhi56II;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * UTF-8
 * Created by czy  Time : 2021/3/31 16:53
 *
 * @version 1.0
 */
// 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
public class jianzhi56II {
    public static void main(String[] args) {
        int i = new Solution().singleNumber(new int[]{9,1,7,9,7,9,7});
        System.out.println(i);
    }
}
class Solution {
    public int singleNumber(int[] nums) {
        AtomicInteger result= new AtomicInteger();
        HashMap<Integer,Integer> hashMap =new HashMap<>();
        for (int i=0;i<nums.length;i++){
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);
        }
        hashMap.forEach((key,value)->{
            if (value==1)
                result.set(key);
        });
        return result.get();
    }
}

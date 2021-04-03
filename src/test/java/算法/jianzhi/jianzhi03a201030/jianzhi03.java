package 算法.jianzhi.jianzhi03a201030;

import java.util.HashSet;
import java.util.Set;

/**
 * UTF-8
 * Created by czy  Time : 2020/10/30 20:32
 *
 * @version 1.0
 */
class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set=new HashSet<>();
        Integer s=null;
        for (int num:nums){
            if(!set.add(num)){
                s=num;
                break;
            }
        }
        return s;
    }
}
public class jianzhi03 {
    public static void main(String[] args) {

    }
}

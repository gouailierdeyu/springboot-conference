package 算法.jianzhi.jianzhi11a201102;

/**
 * UTF-8
 * Created by czy  Time : 2020/11/2 16:51
 *
 * @version 1.0
 */

/**
 * 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转.
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 */
class Solution {
    public int minArray(int[] numbers) {
        if (numbers.length==1) return numbers[0] ;
        int x=numbers[0];
        for(int i=1;i<numbers.length;i++){
            if(numbers[i]<x){
                return numbers[i];
            }
        }
        return numbers[0];
        //这里一定要返回numbers[0]。
        // 因为可能根本没旋转，第一个是最小的。
        // 还有可能全都一样大，都是一个数，也是返回第一个。

    }
}
public class jianzhi11 {
    public static void main(String[] args) {
        System.out.println(new Solution().minArray(new int[]{1, 2, 34, 56}));
    }
}

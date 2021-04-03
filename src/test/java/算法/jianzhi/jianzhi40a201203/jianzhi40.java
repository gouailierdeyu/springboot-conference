package 算法.jianzhi.jianzhi40a201203;

import java.util.Arrays;

/**
 * UTF-8
 * Created by czy  Time : 2020/12/3 20:51
 *
 * @version 1.0
 */
/*
输入整数数组 arr ，找出其中最小的 k 个数。
例如，输入4、5、1、6、2、7、3、8这8个数字，
则最小的4个数字是1、2、3、4。
 */
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int [] mins = new int[k];
        for (int i=0;i<arr.length;i++){
            if (i==k) break;
            int min =arr[i];
            int j=i;
            for (int p=j;p<arr.length;p++){
                if (min>arr[p]){
                    min=arr[p];
                    j=p;
                }
            }
            if (j!=i){
                int temp=arr[i];
                arr[i]=min;
                arr[j]=temp;
            }

            if (i<k){
                mins[i]=min;
            }
        }
        return mins;
    }
}
public class jianzhi40 {
    public static void main(String[] args) {
        int [] mins = new Solution().getLeastNumbers(new int[]{0,0,1,2,4,2,2,3,1,4},8);
        Arrays.stream(mins).forEach(System.out::println);
    }
}

package 算法.jianzhi.jianzhi29a201213;

import java.util.Arrays;

/**
 * UTF-8
 * Created by czy  Time : 2020/12/13 19:41
 *
 * @version 1.0
 */
/*
输入一个矩阵，
按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int [0];
        int indexi=0,indexj=0,maxi=matrix.length,maxj=matrix[0].length;
        int [] out = new int[maxi*maxj];
        int index = 0;
        while (true){
            for (int j=indexj;j<maxj;j++) {
                out[index] = matrix[indexi][j];
                index++;
            }
            if (index==matrix.length*matrix[0].length)
                break;
            for (int l=indexi+1;l<maxi;l++){
                out[index] = matrix[l][maxj-1];
                index++;
            }
            if (index==matrix.length*matrix[0].length)
                break;
            for (int j = maxj-1-1;j>=indexj;j--){
                out[index] = matrix[maxi-1][j];
                index++;
            }

            if (index==matrix.length*matrix[0].length)
                break;
            for (int i = maxi-1-1;i>=indexi+1;i--){
                out[index] = matrix[i][indexj];
                index++;
            }

            indexi++;
            indexj++;
            maxi--;
            maxj--;
            if (index==matrix.length*matrix[0].length)
                break;

        }
        return out;
    }
}
public class jianzhi29 {
    public static void main(String[] args) {
        int [] out = new Solution().spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
        Arrays.stream(out).forEach(System.out::print);
    }
}

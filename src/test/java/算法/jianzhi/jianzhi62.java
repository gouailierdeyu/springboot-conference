package 算法.jianzhi;

import java.util.ArrayList;

/**
 * UTF-8
 * Created by czy  Time : 2020-08-04 00:17
 *
 * @version 1.0
 */

/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class jianzhi62 {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        for(int i=0;i!=n;i++){
            arrayList.add(i);
        }
        int i=0;
        int index=0;
        while (arrayList.size()!=1){
            index=(m+index-1)%(n-i);
            arrayList.remove(index);
            i=i+1;
        }

        return arrayList.get(0);
    }
/**
 * eg n 5,3;得出下标
 *  (3+0-1)%(5-0)=2
 *  (3+2-1)%(5-1)=0
 *  (3+0-1)%(5-2)=2
 *  (3+2-1)%(5-3)=0
 *  最后删除下标得到值
 */
    public static void main(String[] args) {
        System.out.println(new jianzhi62().lastRemaining(10,17));
    }
}

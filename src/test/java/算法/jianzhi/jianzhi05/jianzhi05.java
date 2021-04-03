package 算法.jianzhi.jianzhi05;

/**
 * UTF-8
 * Created by czy  Time : 2020/9/24 20:35
 *
 * @version 1.0
 */
class Solution {
    public String replaceSpace(String s) {

        return s.replaceAll(" ","%20");
    }
    public String replaceSpace2(String s) {
        char c=0;
        StringBuilder rs= new StringBuilder();
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                rs.append("%20");
            }else
                rs.append(s.charAt(i));
        }
        return rs.toString();
    }
}
public class jianzhi05 {
    public static void main(String[] args) {
        System.out.println(new Solution().replaceSpace("hello world!"));
    }
}

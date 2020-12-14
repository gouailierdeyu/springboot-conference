package jianzhi;

/**
 * UTF-8
 * Created by czy  Time : 2020/9/15 21:05
 *
 * @version 1.0
 */
class Solution58 {
    public String reverseLeftWords(String s, int n) {
        String substr=s.substring(0,n);
        String returns=s.substring(n, s.length())+substr;
        return returns;
    }
}

public class jianzhi58II {
    public static void main(String[] args) {
        String s="lrloseumgh";
        int n=6;
        System.out.println( new Solution58().reverseLeftWords(s,n));
    }
}

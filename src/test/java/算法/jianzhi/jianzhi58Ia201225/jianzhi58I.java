package 算法.jianzhi.jianzhi58Ia201225;


/**
 * UTF-8
 * Created by czy  Time : 2020/12/25 16:13
 *
 * @version 1.0
 */
// 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
// 为简单起见，标点符号和普通字母一样处理。
// 例如输入字符串"I am a student. "，则输出"student. a am I"。

class Solution {
    public String reverseWords(String s) {
        String[] slist=s.split("\\s+"); // 利用正则表达式去除多个空格
        if (slist.length==0) return "";
        if (slist.length==1) return slist[0];
        int i=0;
        int j= slist.length-1;
        while (i<=j){
            swap(slist,i,j);
            i++;j--;
        }
        StringBuilder stringBuffer = new StringBuilder();
        for (int i1 = 0; i1 < slist.length; i1++) {
            stringBuffer.append(slist[i1]+' ');
            //stringBuffer.append(value).append(' ');
        }
        return stringBuffer.deleteCharAt(stringBuffer.length()-1).toString();
    }

    private void swap(String[] slist, int i, int j) {
        String temp = slist[i];
        slist[i] = slist[j];
        slist[j] = temp;
    }
}
public class jianzhi58I {
    public static void main(String[] args) {
      String s=  new Solution().reverseWords("a good   example");
        System.out.println(s);
    }
}

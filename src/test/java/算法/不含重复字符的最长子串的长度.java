package 算法;

import java.util.HashSet;
import java.util.Set;

/**
 * UTF-8
 * Created by czy  Time : 2021/4/3 19:40
 *
 * @version 1.0
 */
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//    输入: s = "pwwkew"
//    输出: 3
//    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//    请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

public class 不含重复字符的最长子串的长度 {
    public static void main(String[] args) {
        int pwwkew = new Solution().lengthOfLongestSubstring("pwwkew");
        System.out.println(pwwkew);
    }
}

// pwwkew
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return  0 ;
        char[] str=s.toCharArray();
        int left=0;
        int right=1;
        int max=1;
        Set<Character> set=new HashSet<>();
        set.add(str[left]);
        while (right<str.length){
            if (set.contains(str[right]))
            {
                max = Math.max(max,set.size());
                int i=left;
                while (set.contains(str[right])){
                    set.remove(str[i]);
                    i++;
                }
                set.add(str[right]);
                left=i;

            }else {
                set.add(str[right]);
                max = Math.max(max,set.size());
            }
            right++;
        }

        return max;
    }
}

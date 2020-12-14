package jianzhi;

import java.util.ArrayList;

/**
 * UTF-8
 * Created by czy  Time : 2020-08-01 23:01
 *
 * @version 1.0
 */
public class jianzhi50 {
    public char firstUniqChar(String s) {
        if(s==null ||s.equals("")){
            return ' ';
        }
        ArrayList<Character> characterArrayList=new ArrayList<>();
        ArrayList<Integer> integerArrayList=new ArrayList<>();
        characterArrayList.add(s.charAt(0));
        integerArrayList.add(1);
        for (int i=1;i!=s.length();i++) {
            char c=s.charAt(i);
            int index=characterArrayList.indexOf(c);
            if(index>=0){
                integerArrayList.set(index, integerArrayList.get(index) + 1);
            }else {
                characterArrayList.add(s.charAt(i));
                integerArrayList.add(1);
            }
        }
        int j=0;
        for(j=0;j!=integerArrayList.size();j++){
            if(integerArrayList.get(j)==1){
                break;
            }
        }
        if(j==integerArrayList.size()){
            return ' ';
        }
        else {
            return characterArrayList.get(j);
        }

    }

    public static void main(String[] args) {
        String s=null;
        char c=new jianzhi50().firstUniqChar(s);
        System.out.println(c);
    }
}

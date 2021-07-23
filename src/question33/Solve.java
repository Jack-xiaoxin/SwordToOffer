package question33;

import java.util.*;

public class Solve {

    public static void main(String[] args) {
        String s = "abc";
        String[] strs = new Solve().permutation(s);
        System.out.println(Arrays.toString(strs));
    }

    public String[] permutation(String s) {

        if(s == null) return null;
        if(s.length() == 0) return new String[0];

        Set<String> strSet = new HashSet<>();
        String result = "";
        int length = s.length();

        recur(s, result, strSet, length);

        String[] strs = new String[strSet.size()];
        int index = 0;
        for(String str : strSet) {
            strs[index++] = str;
        }
        return strs;
    }

    public void recur(String str, String result, Set<String> strSet, int length) {
        if(str == null) return ;
        if(result.length() == length) {
            String temp = new String(result);
            strSet.add(temp);
            return ;
        }
        for(int i = 0; i < str.length(); i++) {
            recur(str.substring(0,i)+str.substring(i+1), result+str.charAt(i), strSet, length);
        }
    }
}

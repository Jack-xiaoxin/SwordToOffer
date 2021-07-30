package question45;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class Solve {

    public static void main(String[] args) {
        System.out.println(new Solve().firstUniqChar("leetcode"));
    }

    public char firstUniqChar(String s) {
        if(s == null || s.length() == 0) return ' ';
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(map.containsKey(temp)) map.put(temp, map.get(temp)+1);
            else map.put(temp, 1);
        }
        for(Character temp : map.keySet()) {
            if(map.get(temp) == 1) return temp;
        }
        return ' ';
    }
}

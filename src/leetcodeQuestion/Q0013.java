package leetcodeQuestion;

import java.util.HashMap;
import java.util.Map;

public class Q0013 {

    public static void main(String[] args) {
        System.out.println(new Q0013().romanToInt("IX"));
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>(){
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        int index = 0;
        int result = 0;
        while(index < s.length()) {
            char cur1 = s.charAt(index);
            if(index < s.length() - 1) {
                char cur2 = s.charAt(index+1);
                if(map.get(cur1) < map.get(cur2)) {
                    result += map.get(cur2) - map.get(cur1);
                    index += 2;
                    continue;
                }
            }
            result += map.get(cur1);
            index += 1;
        }
        return result;
    }
}

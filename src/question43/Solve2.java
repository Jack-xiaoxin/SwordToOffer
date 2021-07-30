package question43;

import java.util.HashMap;
import java.util.Map;

public class Solve2 {

    public static void main(String[] args) {
        System.out.println(new Solve2().lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int curLength = 0;
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(map.containsKey(cur) && i - map.get(cur) <= curLength) curLength = i - map.get(cur);
            else curLength++;
            map.put(cur, i);
            if(curLength > max) max = curLength;
        }
        return max;
    }
}

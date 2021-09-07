package leetcodeQuestion;

import java.util.HashMap;
import java.util.Map;

public class Q0003 {

    public static void main(String[] args) {
        int result = new Q0003().lengthOfLongestSubstring2("abba");
        System.out.println(result);
    }

    public int lengthOfLongestSubstring1(String s) {
        if(s == null || s.length() == 0) return 0;
        int length = 2;
        Map<Character, Integer> map = new HashMap<>();
        for(; length <= s.length(); length++) {
            int i = 0;
            while(i <= s.length() - length) {
                map.clear();
                map.put(s.charAt(i), i);
                for(int j = i+1; j < i + length; j++) {
                    if(map.containsKey(s.charAt(j))) {
                        i = map.get(s.charAt(j)) + 1;
                        break;
                    } else map.put(s.charAt(j), j);
                }
                if(map.size() == length) break;
            }
            if(map.size() != length) break;
        }
        return length - 1;
    }

    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int length = 0;
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i)))
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            map.put(s.charAt(i), i);
            length = Math.max(length, i-start+1);
        }
        return length;
    }

}

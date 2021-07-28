package question41;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Solve2 {

    public static void main(String[] args) {
        System.out.println(new Solve2().translateNum(12258));
    }

    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        Map<String, Integer> map = new HashMap<>();
        for(int i = numStr.length()-1; i >= 0; i--) {
            String temp = numStr.substring(i);
            panduan(temp, map);
        }
        return map.get(numStr);
    }

    public void panduan(String temp, Map<String, Integer>map) {
        if(temp.length() == 1) map.put(temp, 1);
        else if(temp.length() == 2) {
            int num = Integer.parseInt(temp);
            if(num >= 10 && num <= 25) map.put(temp, 2);
            else map.put(temp, 1);
        } else {
            int num = Integer.parseInt(temp.substring(0, 2));
            if(num >= 10 && num <= 25) map.put(temp, map.get(temp.substring(1)) + map.get(temp.substring(2)));
            else map.put(temp, map.get(temp.substring(1)));
        }
    }
}

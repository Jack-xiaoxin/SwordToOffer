package question40;

import java.util.Arrays;
import java.util.Comparator;

public class Solve {

    public static void main(String[] args) {
        System.out.println(new Solve().minNumber(new int[]{3, 30, 34, 5, 9}));
    }

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        String result = "";
        for(int i = 0; i < strs.length; i++) result += strs[i];
        return result;
    }
}

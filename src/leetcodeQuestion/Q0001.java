package leetcodeQuestion;

import java.util.HashMap;
import java.util.Map;

public class Q0001 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) map.put(nums[i], i);
            else {
                if(nums[i] * 2 == target) return new int[]{map.get(nums[i]), i};
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] * 2 != target && map.containsKey(target-nums[i]))
                return new int[]{i, map.get(target-nums[i])};
        }
        return null;
    }
}

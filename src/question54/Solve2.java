package question54;


import java.util.Comparator;
import java.util.PriorityQueue;

public class Solve2 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums[o2] - nums[o1];
            }
        });
        for(int i = 0; i < k; i++) queue.add(i);
        int[] result = new int[nums.length - k + 1];
        result[0] = nums[queue.peek()];
        for(int i = 1; i+k-1 < result.length; i++) {
            queue.remove(i-1);
            queue.add(i+k-1);
            result[i] = nums[queue.peek()];
        }
        return result;
    }
}

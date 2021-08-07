package question54;

import java.util.Deque;
import java.util.LinkedList;

public class Solve3 {

    public static void main(String[] args) {
        new Solve3().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 1);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < k; i++) {
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        int[] result = new int[nums.length-k+1];
        result[0] = nums[deque.peek()];
        for(int i = k; i < nums.length; i++) {
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addFirst(i);
            if(deque.peek() < i-k) deque.pollFirst();
            result[i-k] = nums[deque.peek()];
        }
        return result;
    }
}

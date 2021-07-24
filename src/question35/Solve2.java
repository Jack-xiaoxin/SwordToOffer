package question35;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solve2 {

    public static void main(String[] args) {
        int[] result = new Solve2().getLeastNumbers(new int[]{0, 0, 1, 2, 4, 2, 2, 3, 1, 4}, 8);
        System.out.println(Arrays.toString(result));
    }

    //解法2：priorityQueue，自动进行排序，最大的元素在最前面，其实就是大顶堆！！！
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k <= 0) return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
            if(queue.size() > k) queue.poll();
        }
        int[] result = new int[k];
        for(int i = 0; i < k; i++) result[i] = queue.poll();
        return result;
    }
}

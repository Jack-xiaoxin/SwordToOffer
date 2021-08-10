package leetcodeeveryday;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q0809 {

    public static void main(String[] args) {
        System.out.println(new Q0809().nthSuperUglyNumber(40, new int[]{2,3,11,13,17,23,29,31,37,47}));
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] result = new int[n];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] * result[o1[1]] - o2[0] * result[o2[1]];
            }
        });
        result[0] = 1;
        for(int i = 0; i < primes.length; i++) {
            queue.add(new int[]{primes[i], 0});
        }
        for(int i = 1; i < n; i++) {
            int[] temp = queue.poll();
            result[i] = temp[0] * result[temp[1]];
            temp[1] += 1;
            queue.add(temp);
            while(queue.peek()[0] * result[queue.peek()[1]] == result[i]) {
                temp = queue.poll();
                temp[1] += 1;
                queue.add(temp);
            }
        }
        return result[n-1];
    }


}

package question36;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solve {
}

// 使用一个大顶堆和一个小顶堆来做
class MedianFinder {

    //大顶堆
    private Queue<Integer> queue1 = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    //小顶堆
    private Queue<Integer> queue2 = new PriorityQueue<>();

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if(queue1.size() == queue2.size()) queue1.add(num);
        else queue2.add(num);
        if(!queue1.isEmpty() && !queue2.isEmpty() && queue1.peek() > queue2.peek()) {
            int temp = queue1.poll();
            queue1.add(queue2.poll());
            queue2.add(temp);
        }
    }

    public double findMedian() {
        if(getSize() == 0) throw new RuntimeException("空数组，无法返回");
        if(getSize() % 2 == 0) return (queue1.peek() + queue2.peek()) / 2.0;
        else return queue1.peek();
    }

    private int getSize() {
        return queue1.size() + queue2.size();
    }

}

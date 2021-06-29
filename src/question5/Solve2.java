package question5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solve2 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
    }
}

class MyStack {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        if(this.empty()) throw new RuntimeException("队列空，无法出队");
        while(queue1.size() != 1) queue2.add(queue1.poll());
        int result = queue1.poll();
        while(!queue2.isEmpty()) queue1.add(queue2.poll());
        return result;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public int top() {
        if(this.empty()) throw new RuntimeException("队列空，无法出队");
        while(queue1.size() != 1) queue2.add(queue1.poll());
        int result = queue1.peek();
        queue2.add(queue1.poll());
        while(!queue2.isEmpty()) queue1.add(queue2.poll());
        return result;
    }
}

package question5;

import java.util.Stack;

public class Solve1 {

}

class queue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void appendTail(Integer data) {
        stack1.add(data);
    }

    public int deleteHead() {
        if(stack2.empty() && stack1.empty()) throw new RuntimeException("队列为空，无法出栈");
        else if(stack2.empty()) {
            while(!stack1.empty()) stack2.add(stack1.pop());
        }
        return stack2.pop();
    }
}

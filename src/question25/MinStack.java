package question25;


import java.util.List;

import java.util.ArrayList;

//解法：搞两个栈，一个正常存储，一个只存储当前情况下的最小元素
public class MinStack {

    List<Integer> stack;
    List<Integer> stackMin;
    int top = -1;

    public MinStack() {
        stack = new ArrayList<>();
        stackMin = new ArrayList<>();
    }

    public void push(int x) {
        if(isEmpty()) {
            stack.add(x);
            stackMin.add(x);
        } else {
            if(x < stackMin.get(top)) stackMin.add(x);
            else stackMin.add(stackMin.get(top));
            stack.add(x);
        }
        top++;
    }

    public int pop() {
        if(!isEmpty()) {
            //出栈的时候，两个栈都得出
            int result = stack.remove(top);
            stackMin.remove(top);
            top--;
            return result;
        }
        throw new RuntimeException("栈空，不能弹出");
    }

    public int top() {
        if(!isEmpty()) return stack.get(top);
        throw new RuntimeException("栈空，无法获取顶部元素");
    }

    public int min() {
        if(!isEmpty()) return stackMin.get(top);
        throw new RuntimeException("栈空，无法获取最小元素");
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

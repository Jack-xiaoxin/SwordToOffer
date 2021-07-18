package question26;

import java.util.Stack;

public class Solve {

    public static void main(String[] args) {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 3, 5, 1, 2};
        System.out.println(new Solve().validateStackSequences(pushed, popped));
    }

    //本题有个大前提，数字不会重复。所以我们建立一个栈，要出什么元素就在压栈序列中去找
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        int pPushed = 0, pPopped = 0;
        Stack<Integer> stack = new Stack<>();
        for(; pPushed < popped.length; pPushed++) {
            int number = popped[pPopped];
            while((stack.empty() || stack.peek() != number) && pPopped < popped.length) {
                stack.add(pushed[pPushed++]);
            }
            if(stack.peek() == number) {
                stack.pop();
            }
        }
        if(stack.empty() && pPushed == pushed.length && pPopped == popped.length) return true;
        else return false;
    }
}

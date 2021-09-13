package leetcodeQuestion;

import java.util.Stack;

public class Q0020 {

    public static void main(String[] args) {
        System.out.println(new Q0020().isValid("(){}[]"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch =='{') {
                stack.push(ch);
            } else {
                if(stack.empty() || !isMatch(stack.peek(), ch)) return false;
                else stack.pop();
            }
        }
        if(stack.empty()) return true;
        else return false;
    }

    public boolean isMatch(char a, char b) {
        if(a == '(' && b != ')') return false;
        if(a == '[' && b != ']') return false;
        if(a == '{' && b != '}') return false;
        return true;
    }
}

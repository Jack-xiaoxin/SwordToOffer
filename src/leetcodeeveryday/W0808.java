package leetcodeeveryday;

import java.util.List;

import java.util.*;

public class W0808 {

    public static void main(String[] args) {
        W0808 w0808 = new W0808();
        System.out.println(w0808.minStoneSum(new int[]{10000}, 10000));
//        new W0808().longestObstacleCourseAtEachPosition(new int[]{5, 3, 3, 4, 5, 5, 3, 5, 1, 5});
    }

    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length && sb.length() < s.length(); i++) {
            sb.append(words[i]);
        }
        if(sb.length() != s.length() || sb.toString().compareTo(s) != 0) return false;
        return true;
    }

    public int minStoneSum(int[] piles, int k) {
        //如果compartor的值是正数，o2在o1前面。所以大优先队列的比较器里面的compare方法里需要写o2-o1
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        //count记录最后的返回结果
        int count = 0;
        for(int i = 0; i < piles.length; i++) {
            queue.add(piles[i]);
            count += piles[i];
        }
        while(k > 0) {
            count -= queue.peek() / 2;
            queue.add(queue.peek() / 2 + (queue.peek() % 2 == 1 ? 1 : 0));
            queue.poll();
            k--;
        }
        return count;

    }

    public int minSwaps(String s) {
//        int count = 0;
//        int right = s.length()-1;
//        Stack<Character> stack = new Stack<>();
//        char[] ch = s.toCharArray();
//        for(int i = 0; i < ch.length; i++) {
//            if(ch[i] == '[') stack.add(ch[i]);
//            else {
//                if(stack.empty()) {
//                    while(right > i && ch[right] != '[') right--;
//                    ch[i] = '[';
//                    ch[right] = ']';
//                    stack.add(ch[i]);
//                    count++;
//                }
//                stack.pop();
//            }
//        }
//        return count;

        int cnt = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '[') {
                cnt++;
            } else {
                if(cnt > 0) cnt--;
            }
        }
        return (cnt+1) >> 1;
    }

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] result = new int[obstacles.length];
        int[] stack = new int[obstacles.length];
        int top = -1;
        int index = 0;
        for(int ob : obstacles) {
            if(top == -1 || ob >= stack[top]) {
                stack[++top] = ob;
                result[index++] = top + 1;
            } else {
                int l = 0, r = top, m;
                while(l < r) {
                    m = l + (r - l) / 2;
                    if(stack[m] <= ob) l = m + 1;
                    else r = m;
                }
                stack[r] = ob;
                result[index++] = r + 1;
            }
        }
        return result;
    }
}

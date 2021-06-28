package question4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solve {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println("方法1的结果：" + Arrays.toString(solve1(node1)));
        System.out.println("方法2的结果：" + Arrays.toString(solve2(node1)));

    }

    //解法1：使用栈
    public static int[] solve1(Node head) {
        Node p = head;
        Stack<Integer> stack = new Stack<>();
        while(p != null) {
            stack.add(p.value);
            p = p.next;
        }
        int[] result = new int[stack.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static int[] solve2(Node head) {
        if(head == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        xunhuan(head, list);
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void xunhuan(Node node, List<Integer> list) {
        if(node.next != null) xunhuan(node.next, list);
        list.add(node.value);
    }
}


class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}
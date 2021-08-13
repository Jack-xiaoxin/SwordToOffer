package question57;

public class Solve1 {

    public static void main(String[] args) {
        System.out.println(new Solve1().lastRemaining(10, 17));
    }

    public int lastRemaining(int n, int m) {
        //定义一个环形链表
        Node head = new Node(0);
        Node temp = head;
        for(int i = 1; i < n; i++) {
            Node node = new Node(i);
            temp.next = node;
            temp = temp.next;
        }
        temp.next = head;

        //开始遍历，直到只剩一个元素，这个用temp.next!=temp可以进行判断
        while(temp.next != temp) {
            for(int i = 0; i < m - 1; i++) {
                temp = temp.next;
            }
            //删除temp后面的一个元素
            temp.next = temp.next.next;
        }
        return temp.val;
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

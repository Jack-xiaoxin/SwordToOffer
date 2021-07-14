package question17;

public class Solve {

    public static void main(String[] args) {
        ListNode node6 = new ListNode(6, null);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        System.out.println(solve(node1, 3).val);
    }

    public static ListNode solve(ListNode head, int k) {
        if(head == null) return null;
        ListNode p1 = head, p2 = head;
        k--;
        while(k > 0 && p2 != null) {
            p2 = p2.next;
            k--;
        }
        if(p2 == null) return null;
        while(p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}

class ListNode {

    int val;

    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

package question21;

public class Solve {

    public static void main(String[] args) {
        ListNode node0 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        System.out.println(new Solve().detectCycle(node0).val);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode metting = getMettingNode(head);
        if(metting == null) return null;
        ListNode temp = metting.next;
        int count = 1;
        while(temp != metting) {
            count++;
            temp = temp.next;
        }
        ListNode p1 = head, p2 = head;
        while(count-- > 0) p2 = p2.next;
        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;

    }

    public ListNode getMettingNode(ListNode head) {
        if(head == null) return null;
        ListNode p1 = head, p2 = head;
        while(p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
            if(p2 == null) return null;
            p2 = p2.next;
            if(p1 == p2) return p1;
        }
        return null;
    }
}

class ListNode {

    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    };

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
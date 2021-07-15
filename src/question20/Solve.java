package question20;

public class Solve {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0, null);
        ListNode p = head;
        ListNode p1 = l1, p2 = l2;
        while(p1 != null && p2 != null) {
            if(p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            }
            else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        while(p1 != null) {
            p.next = p1;
            p1 = p1.next;
            p = p.next;
        }
        while(p2 != null) {
            p.next = p2;
            p2 = p2.next;
            p = p.next;
        }
        p.next = null;
        return head.next;
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

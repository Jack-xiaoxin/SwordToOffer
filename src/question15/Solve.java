package question15;

public class Solve {

    public ListNode deleteNode(ListNode head, ListNode delete) {
        ListNode temp = delete.next;
        delete.val = temp.val;
        delete.next = temp.next;
        return head;
    }
}

class ListNode {

    int val;

    ListNode next;
}

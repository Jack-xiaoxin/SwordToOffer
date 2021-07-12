package question15;

public class Solve {

    public ListNode deleteNode(ListNode head, ListNode delete) {
        if(head == null || delete == null) return null;
        if(delete.next == null) delete = null;
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

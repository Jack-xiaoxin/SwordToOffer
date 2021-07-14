package question19;

public class Solve {

    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode pre = null, now = head, nex = head.next;
        while(now != null) {
            now.next = pre;
            pre = now;
            now = nex;
            if(nex != null)
                nex = nex.next;
        }
        return pre;
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

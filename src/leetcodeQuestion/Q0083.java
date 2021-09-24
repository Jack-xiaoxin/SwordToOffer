package leetcodeQuestion;

public class Q0083 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode cur = head;
        while(cur.next != null) {
            int curNum = cur.val;
            int nextNum = cur.next.val;
            if(curNum == nextNum) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return head;
    }
}

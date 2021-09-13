package leetcodeQuestion;

public class Q0021 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode result = new ListNode(0);
        ListNode temp = result;

        while(cur1 != null && cur2 != null) {
            if(cur1.val < cur2.val) {
                temp.next = cur1;
                cur1 = cur1.next;
            } else {
                temp.next = cur2;
                cur2 = cur2.next;
            }
            temp = temp.next;
        }
        while(cur1 != null) {
            temp.next = cur1;
            cur1 = cur1.next;
            temp = temp.next;
        }
        while(cur2 != null) {
            temp.next = cur2;
            cur2 = cur2.next;
            temp = temp.next;
        }
        return result.next;
    }
}

package leetcodeQuestion;

import java.awt.*;

public class Q0002 {

    public static void main(String[] args) {
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(4);

        node2.next = node4;
        node4.next = node3;

        node5.next = node6;
        node6.next = node7;

        new Q0002().addTwoNumbers(node2, node5);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int num = 0;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while(l1 != null && l2 != null) {
            num = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            temp.next = new ListNode(num);
            l1 = l1.next;
            l2 = l2.next;
            temp = temp.next;
        }
        while(l1 != null) {
            num = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            temp.next = new ListNode(num);
            l1 = l1.next;
            temp = temp.next;
        }
        while(l2 != null) {
            num = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            temp.next = new ListNode(num);
            l2 = l2.next;
            temp = temp.next;
        }
        if(carry != 0) temp.next = new ListNode(carry);
        return result.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

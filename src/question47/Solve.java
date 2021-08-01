package question47;

public class Solve {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA, tempB = headB;
        int countA = getLength(tempA), countB = getLength(tempB);
        if(countA > countB) return bianli(countA, headA, countB, headB);
        else return bianli(countB, headB, countA, headA);
    }

    public int getLength(ListNode node) {
        int length = 0;
        while(node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public ListNode bianli(int countA, ListNode headA, int countB, ListNode headB) {
        while(countA > countB) {
            headA = headA.next;
            countA--;
        }
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}

class ListNode {
    int val;
    ListNode next;
}

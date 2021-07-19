package question30;

public class Solve2 {

    //高端写法：https://blog.csdn.net/qq_37054755/article/details/115588459
    public Node copyRandomList(Node head)  {
        if(head == null) return null;

        //在每个节点后面新增一个节点
        Node p = head;
        while(p != null) {
            Node temp = new Node(p.val);
            temp.next = p.next;
            p.next = temp;
            p = p.next.next;
        }

        //确定新增节点的random节点
        p = head;
        while(p != null) {
            Node cp = p.next;
            if(p.random == null) cp.random = null;
            else cp.random = p.random.next;
            p = p.next.next;
        }

        //将新增的节点从原链表中摘出来
        p = head;
        Node chead = p.next;
        while(p != null) {
            Node cp = p.next;
            p.next = cp.next;
            if(cp.next != null) cp.next = cp.next.next;
            else cp.next = null;
            p = p.next;
        }

        return chead;
    }
}

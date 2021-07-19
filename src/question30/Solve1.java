package question30;

import java.util.HashMap;
import java.util.Map;

public class Solve1 {

    //为什么要对节点编号呢？直接保存<Node, Node>的map不就好了嘛
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node, Node> map = new HashMap<>();

        Node p = head;
        while(p != null) {
            Node temp = new Node(p.val);
            map.put(p, temp);
            p = p.next;
        }
        map.put(null, null);

        p = head;
        while(p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }

        return map.get(head);
    }
}

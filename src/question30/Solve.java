package question30;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solve {

    //为链表中的每个节点编号，存在map中，或者list中
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Integer, Node> resultMap = new HashMap<>();
        Map<Node, Integer> headMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        //第一次遍历，构建resultMap和headMap
        Node p = head;
        int index = 0;
        while(p != null) {
            Node temp = new Node(p.val);
            resultMap.put(index, temp);
            headMap.put(p, index++);
            p = p.next;
        }
        resultMap.put(index++, null);

        //第二次遍历，将resultMap中的节点串起来；构建list
        p = head;
        index = 0;
        while(p != null) {
            resultMap.get(index).next = resultMap.get(index+1);
            list.add(headMap.get(p.random));
            index++;
            p = p.next;
        }

        //构建random
        index = 0;
        while(index < resultMap.size()) {
            resultMap.get(index).random = resultMap.get(list.get(index));
            index++;
        }

        return resultMap.get(0);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
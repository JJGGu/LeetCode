package Hot100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 自己实现双端链表
 * @author: JJGGu
 * @create: 2020-11-09 18:17
 **/

// 注意点：1.有头尾两个指针，初始化时应当互相指向
public class LRUCache2 {
    class BNode {
        int key;
        int val;
        BNode next;
        BNode pre;
        BNode(int k, int v) {
            key = k;
            val = v;
        }
    }
    class BLinkedList {
        BNode head = new BNode(-1,-1);
        BNode tail = new BNode(-1, -1);

        void removeNode(BNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        void addToHead(BNode node) {
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
        }
        int removeTail() {
            BNode cur = tail.pre;
            int k = cur.key;
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
            cur.next = null;
            cur.pre = null;
            return k;
        }
        void moveToHead(BNode bNode) {
            removeNode(bNode);
            addToHead(bNode);
        }
        BLinkedList() {
            head.next = tail;
            tail.pre = head;
        }
    }
    BLinkedList bLinkedList;
    Map<Integer, BNode> map;
    int capacity;
    public LRUCache2(int capacity) {
        bLinkedList = new BLinkedList();
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            BNode node = map.get(key);
            bLinkedList.moveToHead(node);
            return node.val;
        } else {
            return  -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            BNode node = map.get(key);
            if (node.val != value) {
                node.val = value;
                map.put(key, node);
            }
            bLinkedList.moveToHead(node);
        } else {
            BNode node = new BNode(key, value);
            bLinkedList.addToHead(node);
            map.put(key, node);
        }
        if (map.size() > capacity) {
            int k = bLinkedList.removeTail();
            map.remove(k);
        }
    }
}

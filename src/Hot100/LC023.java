package Hot100;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 合并K个升序链表
 * @author: JJGGu
 * @create: 2020-10-25 14:18
 **/
public class LC023 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists);
    }
    //1。优先队列创建新链表(堆)
    private ListNode merge(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode listNode: lists) {
            while (listNode != null) {
                queue.offer(listNode);
                listNode = listNode.next;
            }
        }
        // 头插法创建新链表
        ListNode head = new ListNode();
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            poll.next = head.next;
            head.next = poll;
        }
        return head.next;
    }

    // 方法二 两两合并
}

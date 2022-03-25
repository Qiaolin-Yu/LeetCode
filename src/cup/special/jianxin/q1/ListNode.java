package cup.special.jianxin.q1;

/**
 * @author 1iin
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode deleteListNode(ListNode head) {
        ListNode temp = head;
        while (temp.next != null && temp.next.next != null) {
            temp.next = temp.next.next;
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
}

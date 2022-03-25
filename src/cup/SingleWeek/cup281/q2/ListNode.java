package cup.SingleWeek.cup281.q2;

import java.util.List;

/**
 * @author 1iin
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode newPre = new ListNode();
        ListNode newNode = newPre;
        ListNode left = new ListNode();
        left.next = head;
        while (left.next != null) {
            if (left.next.val == 0) {
                int sum = 0;
                ListNode right = left.next.next;
                if (right == null) {
                    break;
                }
                while (right.next != null) {
                    sum += right.val;
                    if (right.next.val == 0) {
                        break;
                    }
                    right = right.next;
                }
                if (sum == 0) {
                    break;
                }
                newNode.next = new ListNode(sum);
                newNode = newNode.next;
                left = right;
            } else {
                left = left.next;
            }
        }
        return newPre.next;
    }
}
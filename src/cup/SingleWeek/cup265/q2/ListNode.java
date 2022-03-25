package cup.SingleWeek.cup265.q2;

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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int count = 1;
        int firstNode = -1;
        int lastNode = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while (head.next != null && head.next.next != null) {
            if ((head.next.val > head.val && head.next.val > head.next.next.val) ||
                    (head.next.val < head.val && head.next.val < head.next.next.val)) {
                if (lastNode != -1) {
                    min = Math.min(min, count - lastNode);
                    max = Math.max(max, count - firstNode);
                }
                lastNode = count;
                if (firstNode == -1) {
                    firstNode = count;
                }
            }
            head = head.next;
            count++;
        }
        max = max == Integer.MIN_VALUE ? -1 : max;
        min = min == Integer.MAX_VALUE ? -1 : min;
        return new int[]{min, max};
    }
}

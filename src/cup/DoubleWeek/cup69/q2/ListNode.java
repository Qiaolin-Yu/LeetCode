package cup.DoubleWeek.cup69.q2;

import java.util.ArrayList;
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
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int res = 0;
        for (int i = 0; i <= (list.size() / 2) - 1; i++) {
            res = Math.max(res, list.get(i) + list.get(list.size() - 1 - i));
        }
        return res;
    }
}
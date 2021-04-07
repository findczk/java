package leetcode;

/**
 * 61. 旋转链表
 * @author dsx
 */
public class Solution61 {
    int k = 0;
    ListNode result = null;
    public ListNode rotateRight(ListNode head, int k) {
        this.k = k;
        rotateRight(head, head, 0);
        return result;
    }

    private void rotateRight(ListNode head, ListNode current, int d) {
        if (current == null) {
            k = d == 0 ? 0 : k % d;
            return;
        }
        rotateRight(head, current.next, d + 1);
        if (current.next == null) {
            current.next = head;
        }
        if (k == 0) {
            head = current.next;
            current.next = null;
            result = head;
        }
        k--;
    }
}

package leetcode;

/**
 * @author dsx
 */
public class Solution7 {

    int i = 1;

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            if (i % k == 0) {
                i++;
                next = cur.next;
                cur.next = null;
                head = reverse(head);
                cur = head;
                while (cur.next != null) {
                    cur = cur.next;
                }
                cur.next = reverseKGroup(next, k);
                return head;
            }else {
                cur = cur.next;
                i++;
            }
        }
        return head;
    }


    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

}

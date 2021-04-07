package leetcode;

/**
 * 83. 删除排序链表中的重复元素
 * @author dsx
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                ListNode next = cur.next;
                while (next != null && next.val == cur.val) {
                    next = next.next;
                }
                cur.next = next;
            }
            cur = cur.next;
        }

        return head;
    }
}

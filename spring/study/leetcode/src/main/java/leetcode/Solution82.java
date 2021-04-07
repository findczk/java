package leetcode;

/**
 * 82. 删除排序链表中的重复元素 II
 * @author dsx
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode parent = new ListNode(head.val - 1, head);
        ListNode cur = parent;
        while (cur != null) {
            if (cur.next != null && cur.next.next != null && cur.next.val == cur.next.next.val) {
                ListNode next = cur.next.next.next;
                int val = cur.next.val;
                while (next != null && next.val == val) {
                    next = next.next;
                }
                cur.next = next;
            }else {
                cur = cur.next;
            }
        }

        return parent.next;
    }
}

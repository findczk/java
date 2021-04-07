package leetcode;

/**
 * @author dsx
 */
public class Solution5 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        if (lists.length == 2) return mergeTwoLists(lists[0], lists[1]);

        int mid = lists.length / 2;
        ListNode[] left = new ListNode[mid];
        for (int i = 0; i < left.length; i++) {
            left[i] = lists[i];
        }
        ListNode[] right = new ListNode[lists.length - mid];
        for (int i = 0; i < right.length; i++) {
            right[i] = lists[mid + i];
        }

        return mergeTwoLists(mergeKLists(left),mergeKLists(right));
    }


    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = null;
        if (l1.val <= l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        }else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }

}

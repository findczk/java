package leetcode;

/**
 * @author dsx
 */
public class Solution2 {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode parent = new ListNode();
//        t(parent, l1, l2);
//        return parent.next;
//    }
//
//    private void t(ListNode head, ListNode listNode1, ListNode listNode2) {
//        if (listNode1 == null && listNode2 == null) return;
//        if (listNode1 == null) {
//            head.next = listNode2;
//        }else if  (listNode2 == null){
//            head.next = listNode1;
//        }else if (listNode1.val < listNode2.val) {
//            head.next = new ListNode(listNode1.val);
//            t(head.next, listNode1.next, listNode2);
//        }else {
//            head.next = new ListNode(listNode2.val);
//            t(head.next, listNode1, listNode2.next);
//        }
//    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

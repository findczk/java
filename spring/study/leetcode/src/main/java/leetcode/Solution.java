package leetcode;

public class Solution {

//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        return t(head, n) < 1 ? head : head.next;
//    }
//
//    private int t(ListNode cur,int n) {
//        if (cur.next == null) return n;
//        int t = t(cur.next, n) - 1;
//        if (t == 0) cur.next = cur.next.next;
//        return t;
//    }

    int t = 0;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        head.next = removeNthFromEnd(head.next, n);
        t++;
        if (n == t) return head.next;
        return head;
    }

}
package com.cmq.linkedlist;

/**
 * @author xavier.qiu
 * 10/6/18 4:52 PM
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode getListnode() {

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        return root;
    }
}

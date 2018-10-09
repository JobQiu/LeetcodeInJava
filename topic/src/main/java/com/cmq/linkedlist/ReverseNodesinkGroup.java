package com.cmq.linkedlist;

/**
 * @author xavier.qiu
 * 10/6/18 4:54 PM
 */
public class ReverseNodesinkGroup {

    // head -> 1, k = 3 for example,
    public static ListNode reverseKGroup(ListNode head, int k) {

        // 1. corner cases,
        if (head == null || head.next == null || k < 2) return head;

        // 2. dummy is the some node we use to store the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 0 1 2 3 4 5 null


        // tail = 0 , prev = 0, temp = null
        ListNode tail = dummy, prev = dummy, temp;
        int count;// count = 0
        while (true) {
            count = k;// count = 3
            while (count > 0 && tail != null) { // 3->2->1->4->5, we should not reverse the 4 and 5
                count--;
                tail = tail.next;
            }
            if (tail == null) break;//Has reached the end
            // tail = 0->1, 1->2, 2->3

            head = prev.next;//for next cycle
            // head = 1

            // prev-->temp-->...--->....--->tail-->....
            // Delete @temp and insert to the next position of @tail
            // prev-->...-->...-->tail-->head-->...
            // Assign @temp to the next node of @prev
            // prev-->temp-->...-->tail-->...-->...
            // Keep doing until @tail is the next node of @prev
            while (prev.next != tail) {
                // prev.next = 1 != 3
                temp = prev.next;//Assign
                // temp = 1,
                prev.next = temp.next;//Delete
                // 0 -> 2
                temp.next = tail.next;
                // 1 -> 4
                tail.next = temp;//Insert
                // 3 -> 1

            }

            tail = head;
            prev = head;

        }
        return dummy.next;

    }


    public static ListNode reverseKGroup2(ListNode head, int k) {

        // 1 2 3 4 5 // for example
        // 3 2 1 5 4

        // head -> 1
        // node end = 1
        //

        ListNode newhead = head; // newhead = 1
        ListNode next = head.next; // next = 2
        ListNode nextnext = next.next;
        next.next = head; // 2->1 and 2 becomes the new head


        ListNode root = new ListNode(-1);
        ListNode lastend = root;

        ListNode newend = head;

        ListNode temp = head;
        ListNode nexthead = head;

        while (head.next != null) {

            newend = head;

            for (int i = 0; i < k; i++) {

                next = head.next; // 2

                nexthead = next.next; // 3

                next.next = head; // 2->1
                head = nexthead; // 3


                // head = 1. head.next = 2
                // 2.next = 1
                // newhead = 2,
                // newend = 1,
                // thehead of next

                // 1->2->3 ->4->5
                //


                // 2->1
                //
                if (temp.next == null) {
                    break;
                } // END of if

            } // END of for i

            lastend.next = temp;
        } // END of while


        return root.next;


    }

    public static void main(String[] args) {

        ListNode res = reverseKGroup(ListNode.getListnode(), 3);
        System.out.println("");

    }
}

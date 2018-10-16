package com.cmq.linkedin;
/*
自己实现一个stack，可以O(1)实现push， pull， getMiddle，讨论了几分钟写完又跑了一下test。

SOlution:
a DLL, and a point to the middle one
 */
public class midStack {
    private Node tail;
    private Node mid;
    private int totalLen;
    public midStack() {
        this.tail = new Node(-1);
        this.mid = tail;
        totalLen = 0;
    }

    public void push(int val) {
        Node node = new Node(val);
        node.prev = tail;
        tail.next = node;
        tail = node;
        totalLen += 1;
        if (totalLen % 2 == 1)
            mid = mid.next;
    }

    public Integer pop() {
        if (totalLen == 0)
            return null;

        Node node = tail;
        tail = node.prev;
        totalLen -= 1;
        if (totalLen % 2 == 0)
            mid = mid.prev;

        node.prev = null;
        tail.next = null;

        return node.val;
    }

    public Integer peekMid() {
        if (totalLen == 0)
            return null;

        return mid.val;
    }

    public Integer popMid() {
        if (totalLen == 0)
            return null;

        Node result = mid;
        Node prev = mid.prev;
        mid.next.prev = prev;
        prev.next = mid.next;
        mid.next = null;
        mid.prev = null;
        totalLen -= 1;
        if (totalLen % 2 == 0)
            mid = prev;
        else
            mid = prev.next;

        return result.val;
    }


    class Node {
        Node prev;
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }
}

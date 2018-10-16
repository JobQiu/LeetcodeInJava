package com.cmq.linkedin;

/*
Question:
2. 双向链表，但是每一个点还可以有up，down pointer， 已知一个链表里没有环，要求把这个链表变成标准双向链表，
每个点的具体位置排列无所谓。楼主开始反应是递归，写好后面试官说优化一下，，空间要求是constant space，
然后尽管面试官一直在提示tail recursion，还是没想出来（据说地里有原题，可惜当时楼主没看到。。。跪了= =！）

time O(n);

 */

public class FlattenMetaList {
    class MetaNode {
        MetaNode up, down, prev, next;
        int val;
        public MetaNode(int val) {
            this.val = val;
            up = null;
            down = null;
            prev = null;
            next = null;
        }
    }

    public MetaNode flatten(MetaNode input) {
        if (input == null) return null;

        MetaNode head = getHead(input);
        MetaNode tail = getTail(input);
        MetaNode mover = head;

        while(mover != null) {
            /* for up */
            if (mover.up != null) {
                MetaNode up = mover.up;
                MetaNode upHead = getHead(up);
                tail.next = upHead;
                upHead.prev = tail;
                mover.up = null;
                tail = getTail(tail);
            }

            /* for down */
            if (mover.down != null) {
                MetaNode down = mover.down;
                MetaNode downHead = getHead(down);
                tail.next = down;
                down.prev = tail;
                mover.down = null;
                tail = getTail(tail);
            }

            mover = mover.next;
        }

        return head;
    }


    private MetaNode getHead(MetaNode node) {
        while(node.prev != null)
            node = node.prev;
        return node;
    }

    private MetaNode getTail(MetaNode node) {
        while(node.next != null)
            node = node.next;
        return node;
    }
}

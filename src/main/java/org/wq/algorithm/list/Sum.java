package org.wq.algorithm.list;

public class Sum {

    public ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        int add = 0;
        ListNode<Integer> head = new ListNode<>(0);
        ListNode<Integer> tail = head;

        while(l1 != null || l2 != null){
            int s = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + add;
            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);

            add = s / 10;
            tail.next = new ListNode<Integer>(s % 10);
            tail = tail.next;
        }

        if(add != 0)
            tail.next = new ListNode<Integer>(add);

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(7);
        ListNode l12 = new ListNode(1);
        ListNode l13 = new ListNode(6);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(3);
        l21.next = l22;
        l22.next = l23;

        ListNode<Integer> result = new Sum().addTwoNumbers(l11, l21);

        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }

    }
}

package LinkedLists.Utils;

public class LinkedList {

    public ListNode arrayToLinkedList(int[] arr) {

        if (arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode tmp = head;

        for (int i = 1; i < arr.length; i++) {
            tmp.next = new ListNode(arr[i]);
            tmp = tmp.next;
        }

        return head;
    }

    public void printLinkedList(ListNode head) {

        if (head == null) {
            System.out.println("Empty LinkedList!");
            return;
        }

        while (head != null && head.next != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }

        System.out.println(head.val);

    }

    /* Definition for singly-linked list */
    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


    }
}

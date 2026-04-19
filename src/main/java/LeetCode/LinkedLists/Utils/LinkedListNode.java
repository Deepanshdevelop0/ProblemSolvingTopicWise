package LeetCode.LinkedLists.Utils;

public class LinkedListNode {

    public Node arrayToLinkedList(int[] arr) {

        if (arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node tmp = head;

        for (int i = 1; i < arr.length; i++) {
            tmp.next = new Node(arr[i]);
            tmp = tmp.next;
        }

        return head;
    }

    public void printLinkedList(Node head) {

        if (head == null) {
            System.out.println("Empty LinkedList!");
            return;
        }

        while (head != null && head.next != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }

        System.out.println(head.data);

    }


    public static class Node {
        public int data;
        public Node next;

        public Node() {
        }

        public Node(int x) {
            this.data = x;
        }

        public Node(int x, Node next) {
            this.data = x;
            this.next = next;
        }
    }
}

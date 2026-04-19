package LeetCode.LinkedLists.Problems.Medium;


import LeetCode.LinkedLists.Utils.LinkedListNode;
import LeetCode.LinkedLists.Utils.LinkedListNode.Node;

import java.util.ArrayList;
import java.util.List;

public class Add_1_to_a_Linked_List_Number {

    public static void main(String[] args) {
        Add_1_to_a_Linked_List_Number classObj = new Add_1_to_a_Linked_List_Number();
        LinkedListNode linkedList = new LinkedListNode();

        System.out.println("Case 1 : ");
        Node l1 = linkedList.arrayToLinkedList(new int[]{4, 5, 6});
        linkedList.printLinkedList(classObj.addOneOptimized(l1));

        System.out.println("Case 2 : ");
        Node l11 = linkedList.arrayToLinkedList(new int[]{1, 1, 9});
        linkedList.printLinkedList(classObj.addOneOptimized(l11));

        System.out.println("Case 3 : ");
        Node l21 = linkedList.arrayToLinkedList(new int[]{9, 9, 9});
        linkedList.printLinkedList(classObj.addOneOptimized(l21));
    }

    public Node addOne(Node head) {
        if (head == null) {
            return new Node(1);
        }

        List<Node> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }

        int carry = 1;

        for (int i = list.size() - 1; i >= 0; i--) {
            Node node = list.get(i);
            int sum = node.data + carry;
            carry = sum / 10;
            node.data = sum % 10;
        }

        Node newHead = list.get(0);

        if (carry > 0) {
            newHead = new Node(carry);
            newHead.next = list.get(0);
        }

        return newHead;
    }


    public Node addOneOptimized(Node head) {
        if (head == null) {
            return new Node(1);
        }

        head = reverse(head);
        Node dummy = head;

        int carry = 1;

        while (head != null) {
            int sum = head.data + carry;
            carry = sum / 10;
            head.data = sum % 10;
            if (carry == 0) break;
            head = head.next;
        }

        dummy = reverse(dummy);

        if (carry > 0) {
            Node newHead = new Node(carry);
            newHead.next = dummy;
            return newHead;
        }

        return dummy;
    }

    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;

        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }


}

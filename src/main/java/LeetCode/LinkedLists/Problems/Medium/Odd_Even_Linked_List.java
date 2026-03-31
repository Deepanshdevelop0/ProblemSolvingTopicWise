package LeetCode.LinkedLists.Problems.Medium;

import LeetCode.LinkedLists.Utils.LinkedList;
import LeetCode.LinkedLists.Utils.LinkedList.*;

public class Odd_Even_Linked_List {

    public static void main(String[] args) {
        Odd_Even_Linked_List classObj = new Odd_Even_Linked_List();
        LinkedList linkedList = new LinkedList();

        ListNode head = linkedList.arrayToLinkedList(new int[]{1,2,3,4,5});
        System.out.println("Case 1 : ");
        linkedList.printLinkedList(classObj.oddEvenList(head));

        ListNode head1 = linkedList.arrayToLinkedList(new int[]{2,1,3,5,6,4,7});
        System.out.println("Case 2 : ");
        linkedList.printLinkedList(classObj.oddEvenList(head1));

        ListNode head2 = linkedList.arrayToLinkedList(new int[]{2,1,3});
        System.out.println("Case 3 : ");
        linkedList.printLinkedList(classObj.oddEvenList(head2));

    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode odd = head, even = head.next, oddHead = odd, evenHead = even;

        while (odd.next != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            if (odd.next != null) {
                even.next = odd.next;
                even = even.next;
            }
        }

        odd.next = evenHead;
        even.next = null; // to break any link of linkedlist end

        return oddHead;

    }


}

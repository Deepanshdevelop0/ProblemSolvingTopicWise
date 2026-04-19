package LeetCode.LinkedLists.Problems.Medium;


import LeetCode.LinkedLists.Utils.LinkedList;
import LeetCode.LinkedLists.Utils.LinkedList.*;

public class Add_Two_Numbers {

    public static void main(String[] args) {
        Add_Two_Numbers classObj = new Add_Two_Numbers();
        LinkedList linkedList = new LinkedList();

        System.out.println("Case 1 : ");
        ListNode l1 = linkedList.arrayToLinkedList(new int[]{2,4,3});
        ListNode l2 = linkedList.arrayToLinkedList(new int[]{5,6,4});
        linkedList.printLinkedList(classObj.addTwoNumbers(l1, l2));

        System.out.println("Case 2 : ");
        ListNode l11 = linkedList.arrayToLinkedList(new int[]{4, 2, 1, 3});
        ListNode l12 = linkedList.arrayToLinkedList(new int[]{4, 8, 9, 9});
        linkedList.printLinkedList(classObj.addTwoNumbers(l11, l12));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;

            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return dummy.next;
    }

}

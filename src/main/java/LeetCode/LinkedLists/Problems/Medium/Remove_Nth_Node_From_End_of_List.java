package LeetCode.LinkedLists.Problems.Medium;

import LeetCode.LinkedLists.Utils.LinkedList;
import LeetCode.LinkedLists.Utils.LinkedList.*;

import java.util.ArrayList;
import java.util.List;

public class Remove_Nth_Node_From_End_of_List {

    public static void main(String[] args) {

        Remove_Nth_Node_From_End_of_List classObj = new Remove_Nth_Node_From_End_of_List();
        LinkedList linkedList = new LinkedList();

        System.out.println("Case 1 : ");
        ListNode head = linkedList.arrayToLinkedList(new int[]{1,2,3,4,5});
        linkedList.printLinkedList(classObj.removeNthFromEnd(head, 2));

        System.out.println("Case 2 : ");
        ListNode head1 = linkedList.arrayToLinkedList(new int[]{1});
        linkedList.printLinkedList(classObj.removeNthFromEnd(head1, 1));

        System.out.println("Case 3 : ");
        ListNode head2 = linkedList.arrayToLinkedList(new int[]{1,2});
        linkedList.printLinkedList(classObj.removeNthFromEnd(head2, 1));
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        List<ListNode> list = new ArrayList<>();

        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        int indx = list.size() - n - 1;

        if (indx < 0) return head.next; // if we have to remove head node, then return head.next as new head

        ListNode nodeToRemove = list.get(indx);
        nodeToRemove.next = nodeToRemove.next.next;

        return head;

    }
}

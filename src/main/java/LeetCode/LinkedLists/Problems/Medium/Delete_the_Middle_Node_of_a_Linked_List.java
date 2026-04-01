package LeetCode.LinkedLists.Problems.Medium;

import LeetCode.LinkedLists.Utils.LinkedList;
import LeetCode.LinkedLists.Utils.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Delete_the_Middle_Node_of_a_Linked_List {

    public static void main(String[] args) {

        Delete_the_Middle_Node_of_a_Linked_List classObj = new Delete_the_Middle_Node_of_a_Linked_List();
        LinkedList linkedList = new LinkedList();

        System.out.println("Case 1 : ");
        ListNode head = linkedList.arrayToLinkedList(new int[]{1,3,4,7,1,2,6});
        linkedList.printLinkedList(classObj.deleteMiddleMoreOptimal(head));

        System.out.println("Case 2 : ");
        ListNode head1 = linkedList.arrayToLinkedList(new int[]{1});
        linkedList.printLinkedList(classObj.deleteMiddleMoreOptimal(head1));

        System.out.println("Case 3 : ");
        ListNode head2 = linkedList.arrayToLinkedList(new int[]{1,2,3,4});
        linkedList.printLinkedList(classObj.deleteMiddleMoreOptimal(head2));

        System.out.println("Case 4 : ");
        ListNode head3 = linkedList.arrayToLinkedList(new int[]{2,1});
        linkedList.printLinkedList(classObj.deleteMiddleMoreOptimal(head3));
    }


    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        if (head.next.next == null) {
            head.next = null;
            return head;
        }

        List<ListNode> list = new ArrayList<>();

        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        int indx = list.size() / 2;

        ListNode prevNodeToRemove = list.get(indx - 1);
        prevNodeToRemove.next = prevNodeToRemove.next.next;

        return head;
    }

    public ListNode deleteMiddleMoreOptimal(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        if (head.next.next == null) {
            head.next = null;
            return head;
        }

        List<ListNode> list = new ArrayList<>();

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            list.add(slow);
            slow = slow.next;
            fast = fast.next;
        }

        ListNode prevNode = list.get(list.size() - 2);
        prevNode.next = slow.next;

        return head;
    }
}

package LinkedLists.Problems;

import LinkedLists.Utils.LinkedList;
import LinkedLists.Utils.LinkedList.ListNode;

import javax.swing.*;

public class Linked_List_Cycle_II {

    public static void main(String[] args) {

        /*ListNode head = new ListNode(3);
        ListNode cycle = new ListNode(2);
        head.next = cycle;
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(-7);
        head.next.next.next.next.next.next = new ListNode(-3);
        head.next.next.next.next.next.next.next = cycle;*/

        ListNode head = new ListNode(3);
        head.next = new ListNode(2);

        ListNode cycle = new ListNode(0);
        head.next.next = cycle;
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = new ListNode(-5);
        head.next.next.next.next.next = cycle;


        Linked_List_Cycle_II classObj = new Linked_List_Cycle_II();
        ListNode res = classObj.detectCycle(head);
        System.out.println(res.val);

    }

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) return null;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }

        return null;
    }


}

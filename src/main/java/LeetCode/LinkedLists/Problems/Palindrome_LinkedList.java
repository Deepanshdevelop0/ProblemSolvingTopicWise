package LeetCode.LinkedLists.Problems;

import LeetCode.LinkedLists.Utils.LinkedList;
import LeetCode.LinkedLists.Utils.LinkedList.*;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_LinkedList {

    public static void main(String[] args) {
        Palindrome_LinkedList classObj = new Palindrome_LinkedList();
        LinkedList linkedList = new LinkedList();

        ListNode head = linkedList.arrayToLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println("Case 1 : ");
        System.out.println(classObj.isPalindromeMoreOptimal(head));

        ListNode head1 = linkedList.arrayToLinkedList(new int[]{1, 2, 2, 1});
        System.out.println("Case 2 : ");
        System.out.println(classObj.isPalindromeMoreOptimal(head1));

    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        List<Integer> list = new ArrayList<>();

        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        int n = list.size();
        for (int i = 0; i < n/2; i++) {
            if (list.get(i) != list.get(n - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindromeMoreOptimal(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) slow = slow.next; // for odd length linkedlist, move slow one step forward

        ListNode prev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        slow = prev;
        while (slow != null) {
            if (slow.val != head.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }

        return true;
    }


}

package LeetCode.LinkedLists.Problems.Medium;

import LeetCode.LinkedLists.Utils.LinkedList;
import LeetCode.LinkedLists.Utils.LinkedList.*;

import java.util.*;

public class Sort_List {

    public static void main(String[] args) {
        Sort_List classObj = new Sort_List();
        LinkedList linkedList = new LinkedList();

        System.out.println("Case 1 : ");
        ListNode head = linkedList.arrayToLinkedList(new int[]{1, 3, 4, 7, 1, 2, 6});
        linkedList.printLinkedList(classObj.sortListIIOptimal(head));

        System.out.println("Case 2 : ");
        ListNode head1 = linkedList.arrayToLinkedList(new int[]{4, 2, 1, 3});
        linkedList.printLinkedList(classObj.sortListIIOptimal(head1));

        System.out.println("Case 3 : ");
        ListNode head2 = linkedList.arrayToLinkedList(new int[]{});
        linkedList.printLinkedList(classObj.sortListIIOptimal(head2));
    }

    public ListNode sortListI(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        TreeMap<Integer, ListNode> map = new TreeMap<>();
        Map<Integer, Integer> freq = new HashMap<>();

        while (head != null) {
            map.put(head.val, head);
            freq.put(head.val, freq.getOrDefault(head.val, 0) + 1);
            head = head.next;
        }

        ListNode prev = null;

        for (Map.Entry<Integer, ListNode> entry : map.entrySet()) {
            ListNode curr = entry.getValue();
            int frequency = freq.get(entry.getKey());

            while (frequency > 0) {
                if (prev == null) {
                    prev = curr;
                } else {
                    prev.next = new ListNode(curr.val);
                    prev = prev.next;
                }
                frequency--;
            }
        }


        ListNode last = map.lastEntry().getValue();
        last.next = null; // to break any link of linkedlist end

        return map.firstEntry().getValue();
    }


    public ListNode sortListIIOptimal(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        TreeMap<Integer, List<ListNode>> map = new TreeMap<>();

        while (head != null) {
            map.computeIfAbsent(head.val, k -> new ArrayList<>()).add(head);
            head = head.next;
        }

        ListNode prev = new ListNode(0), curr = prev;

        for (List<ListNode> nodes : map.values()) {
            for (ListNode node : nodes) {
                curr.next = node;
                curr = curr.next;
            }
        }

        curr.next = null; // to break any link of linkedlist end

        return prev.next;
    }

}

package LinkedLists.Problems;

import LinkedLists.Utils.LinkedList;
import LinkedLists.Utils.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

public class RotateList {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5};
        int[] arr1 = new int[]{0,1,2};
        int k = 4;

        LinkedList linkedList = new LinkedList();

        ListNode head = linkedList.arrayToLinkedList(arr1);
        linkedList.printLinkedList(head);

        RotateList classObj = new RotateList();
        ListNode res = classObj.rotateRight(head, k);
        linkedList.printLinkedList(res);

    }

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) return head;

        List<ListNode> list = new ArrayList<>();

        ListNode currNode = head;

        while (currNode != null) {
            list.add(currNode);
            currNode = currNode.next;
        }

        k = k % list.size();

        if (k <= 0) return head;

        int n = list.size();

        list.get(n - 1).next = list.get(0);
        list.get(n - (k+1)).next = null;

        return list.get(n - k);
    }


}

package LinkedLists.Problems;

import LinkedLists.Utils.LinkedList.*;

public class mergeInBetweenLinkedList {

    public static void main(String[] args) {

    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode root = list1, aNode = null, bNode = null;
        int count = 0;

        /* place aNode at a-1 position and bNode at b+1 position to create list2 references */
        while (root != null) {

            if (count+1 == a) {
                aNode = root;
            }
            if (count == b) {
                bNode = root.next;
            }

            /* this is ensured that on count = b, the aNode and bNode would have been initialized */
            if (count >= b) break;

            root = root.next;
            count++;
        }

        /* add the list1 a-1 node reference to list2 head node */
        aNode.next = list2;

        /* reach the tail of list2 */
        while(list2.next != null) {
            list2 = list2.next;
        }

        /* add the list1 b+1 node reference to list2 tail node */
        list2.next = bNode;

        return list1;
    }





}

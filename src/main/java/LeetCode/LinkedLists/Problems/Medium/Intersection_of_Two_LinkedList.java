package LeetCode.LinkedLists.Problems.Medium;


import LeetCode.LinkedLists.Utils.LinkedList;
import LeetCode.LinkedLists.Utils.LinkedList.*;

import java.util.HashSet;
import java.util.Set;

public class Intersection_of_Two_LinkedList {

/*

* getIntersectionNode method : (using set)

TC : O(N + M) where N and M are the lengths of the two linked lists. We traverse each list once.

SC : O(N + M) in the worst case, if there is no intersection, we store all nodes of both lists in the set.
-----------------------------------------

* getIntersectionNodeOptimal method : (using two pointers)

TC : O(N + M) where N and M are the lengths of the two linked lists. In the worst case, we traverse both lists twice.

SC : O(1) as we are using only a constant amount of extra space for the two pointers.
-----------------------------------------

Note: The two-pointer approach is more space-efficient and is generally the preferred solution for this problem,
 as it does not require additional data structures and runs in linear time.

*/

    public static void main(String[] args) {
        Intersection_of_Two_LinkedList classObj = new Intersection_of_Two_LinkedList();
        LinkedList linkedList = new LinkedList();

        System.out.println("Case 1 : ");

        // 1. Create the shared intersection part: [8, 4, 5]
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        // 2. Create Head A's unique part and link it to common: [4, 1] -> common
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        // 3. Create Head B's unique part and link it to common: [5, 6, 1] -> common
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        System.out.println("Case 1: Expecting node with value 8");
        ListNode result = classObj.getIntersectionNode(headA, headB);
        linkedList.printLinkedList(result);




        ListNode common1 = new ListNode(2);
        common1.next = new ListNode(4);

        // 2. Create Head A and skip 3 nodes: [1 -> 9 -> 1] -> common
        ListNode headA1 = new ListNode(1);
        headA1.next = new ListNode(9);
        headA1.next.next = new ListNode(1);
        headA1.next.next.next = common1; // This is skipA = 3

        // 3. Create Head B and skip 1 node: [3] -> common
        ListNode headB1 = new ListNode(3);
        headB1.next = common1; // This is skipB = 1

        System.out.println("Case 2: Expecting intersection at node with value 2");
        ListNode result1 = classObj.getIntersectionNode(headA1, headB1);
        linkedList.printLinkedList(result1);

    }



    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA, b = headB;
        Set<ListNode> set = new HashSet<>();

        while (a != null || b != null) {
            if (a != null) {
                if (set.contains(a)) {
                    return a;
                }
                else {
                    set.add(a);
                }
                a = a.next;
            }
            if (b != null) {
                if (set.contains(b)) {
                    return b;
                }
                else {
                    set.add(b);
                }
                b = b.next;
            }
        }

        return null;
    }
    public ListNode getIntersectionNodeOptimal(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA, b = headB;

        /*
         * The Magic Logic:
         * If lists have different lengths (e.g., A is 5 and B is 3), they aren't 'aligned'.
         * By switching heads, both pointers will travel exactly (LengthA + LengthB).
         * * Pass 1: Pointer 'a' traverses List A, Pointer 'b' traverses List B.
         * Pass 2: Pointer 'a' switches to List B, Pointer 'b' switches to List A.
         * * They are guaranteed to meet at the intersection point in Pass 2 because
         * they will have covered the same total distance.
         */
        while (a != b) {
            // If pointer 'a' reaches the end of List A, jump to the start of List B.
            // Otherwise, just move to the next node.
            a = (a == null) ? headB : a.next;

            // If pointer 'b' reaches the end of List B, jump to the start of List A.
            // Otherwise, just move to the next node.
            b = (b == null) ? headA : b.next;
        }

        /*
         * At this point, either:
         * 1. a == b (They met at the intersection node)
         * 2. a == b == null (They both finished both lists and never met)
         */

        return a;
    }



}

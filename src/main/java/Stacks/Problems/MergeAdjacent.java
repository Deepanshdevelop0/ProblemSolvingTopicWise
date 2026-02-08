package Stacks.Problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MergeAdjacent {

    public static void main(String[] args) {

    }

    public List<Long> mergeAdjacent(int[] nums) {

        Deque<Long> st = new ArrayDeque<>();

        for (int i : nums) {
            long curr = (long) i;

            while (!st.isEmpty() && st.peekLast() == curr) {
                curr += st.removeLast();
            }

            st.addLast(curr);
        }

        return new ArrayList<>(st);
    }
}

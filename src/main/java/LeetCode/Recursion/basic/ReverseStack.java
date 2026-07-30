package LeetCode.Recursion.basic;

import java.util.*;

public class ReverseStack {

    public static void main(String[] args) {

    }

    public static void reverseStackIterative(Stack<Integer> st) {

        List<Integer> res = new ArrayList<>();

        while (!st.isEmpty()) {
            res.add(st.pop());
        }

        while (!res.isEmpty()) {
            st.push(res.get(0));
            res.remove(0);
        }
    }

    public static void reverseStackRecursive(Stack<Integer> st) {
        Stack<Integer> res = new Stack<>();

        while (!st.isEmpty()) {
            res.add(st.pop());
        }

        Collections.copy(st, res);
    }



}

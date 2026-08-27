package LeetCode.Recursion.basic;

import java.util.*;

public class ReverseStack {

    public static void main(String[] args) {
        ReverseStack classObj = new ReverseStack();

        Stack<Integer> st = new Stack<>();
        st.add(1);
        st.add(2);
        st.add(3);
        st.add(4);

        reverseStackIterative(st);

        int i = 0;
        while (!st.isEmpty()) {
            System.out.println(i++ + " : " + st.pop());
        }
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
        if (st.isEmpty()) {
            return;
        }

        int peek = st.pop();

        reverseStackRecursive(st);

        addToLast(st, peek);
    }

    public static void addToLast(Stack<Integer> st, int peek) {
        if (st.isEmpty()) {
            st.push(peek);
            return;
        }

        int element = st.pop();

        addToLast(st, peek);

        st.push(element);
    }


}

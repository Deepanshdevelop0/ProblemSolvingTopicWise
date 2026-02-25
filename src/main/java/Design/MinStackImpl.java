package Design;

import java.util.*;

public class MinStackImpl {

    public static void main1(String[] args) {
        MinStackBruteForce minStack = new MinStackBruteForce();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    public static void main(String[] args) {

        MinStackOptimal minStack = new MinStackOptimal();

        minStack.push(0);
        minStack.push(1);
        minStack.push(0);

        System.out.println(minStack.getMin()); // Expected: 0

        minStack.pop();

        System.out.println(minStack.getMin()); // Expected: 0

        minStack.pop();

        System.out.println(minStack.getMin()); // Expected: 0

        minStack.pop();

        minStack.push(-2);
        minStack.push(-1);
        minStack.push(-2);

        System.out.println(minStack.getMin()); // Expected: -2

        minStack.pop();

        System.out.println(minStack.top());    // Expected: -1

        System.out.println(minStack.getMin()); // Expected: -2

        minStack.pop();

        System.out.println(minStack.getMin()); // Expected: -2

        minStack.pop();
    }
}


class MinStackBruteForce {

    record IntPair(long val, long minVal) {
    }

    Stack<IntPair> stack;

    public MinStackBruteForce() {
        stack = new Stack<>();
    }

    public void push(int val) {
        long currMin;
        if (stack.isEmpty()) {
            currMin = val;
        } else {
            currMin = Math.min((long) val, stack.peek().minVal);
        }

        stack.push(new IntPair((long) val, currMin));
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return 0;
        }

        return (int) stack.peek().val;
    }

    public int getMin() {
        if (stack.isEmpty()) {
            return 0;
        }

        return (int) stack.peek().minVal;
    }
}

class MinStackOptimal {

    Stack<Long> stack;

    long min;

    // formula used
    // 2 x curr_pushed_value - prevMin = new_value x

    public MinStackOptimal() {
        stack = new Stack<>();
    }

    public void push(int val) {
        long value = val;
        if (stack.isEmpty()) {
            stack.push(value);
            min = value;
            return;
        }

        if (value > min) {
            stack.push(value);
        } else {
            stack.push(2*value - min);
            min = val;
        }

    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        long x = stack.pop();

        if (x < min) {
            min = 2 * min - x; // min has the value pushed earlier in push method, we added min=val
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return 0;
        }

        long x = stack.peek();

        if (x > min) return (int) x;

        return (int) min;
    }

    public int getMin() {
        return (int) min;
    }
}

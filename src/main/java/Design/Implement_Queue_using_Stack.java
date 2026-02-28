package Design;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Implement_Queue_using_Stack {

/*
 APPROACH 1: Push-Heavy (Your Original Approach)
 -------------------------------------------------
 Elements are re-ordered during every push to keep the oldest at the top.

 Time Complexity (TC):
 1. push()  : O(n) - Moves all elements between stacks twice.
 2. pop()   : O(1) - The front is always at the top of the stack.
 3. peek()  : O(1) - The front is always at the top of the stack.
 4. empty() : O(1)

 Space Complexity (SC): O(n) - Stores n elements across two stacks.


 APPROACH 2: Amortized O(1) (Refactored/Optimized)
 -------------------------------------------------
 Elements are moved only when the output stack is empty, making most operations instant.

 Time Complexity (TC):
 1. push()  : O(1) - Simply push onto the input stack.
 2. pop()   : O(1) (Amortized) - Occasional O(n) transfer, but O(1) on average.
 3. peek()  : O(1) (Amortized) - Occasional O(n) transfer, but O(1) on average.
 4. empty() : O(1)

 Space Complexity (SC): O(n) - Stores n elements across two stacks.
*/


    public static void main(String[] args) {
        MyQueueOptimized queue = new MyQueueOptimized();

        // Test Case 1: Basic Push and Pop
        queue.push(10);
        queue.push(20);
        System.out.println("Peek (should be 10): " + queue.peek());
        System.out.println("Pop (should be 10): " + queue.pop());

        // Test Case 2: Interleaved Push and Pop
        queue.push(30);
        System.out.println("Peek (should be 20): " + queue.peek());
        System.out.println("Pop (should be 20): " + queue.pop());
        System.out.println("Pop (should be 30): " + queue.pop());

        // Test Case 3: Empty check
        System.out.println("Is Empty? (should be true): " + queue.empty());
    }

}


class MyQueueBruteForce {

    Stack<Integer> stack;
    Stack<Integer> stack1;

    public MyQueueBruteForce() {
        stack = new Stack<>();
        stack1 = new Stack<>();
    }

    public void push(int x) {

        while (!stack.isEmpty()) {
            stack1.push(stack.pop());
        }

        stack.push(x);


        while (!stack1.isEmpty()) {
            stack.push(stack1.pop());
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }

        return stack.pop();
    }

    public int peek() {
        if (stack.isEmpty()) {
            return -1;
        }

        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}

class MyQueueOptimized {

    Stack<Integer> input;
    Stack<Integer> output;

    public MyQueueOptimized() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek();
        return output.pop();
    }

    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}

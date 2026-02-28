package Design;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Implement_Queue_using_Stack {

/*

MyStackTwoQueues (Using Two Queues) :

TC :
1. push() : O(n)
2. pop() : O(1)
3. top() : O(1)
4. empty() : O(1)

SC : O(n) (using two queues)

-------------------------------------------------

MyStackOneQueue (Using Single Queue) :

TC :
1. push() : O(n)
2. pop() : O(1)
3. top() : O(1)
4. empty() : O(1)

SC : O(n) (using one queue)

*/



    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

    }

}


class MyQueue {

    Stack<Integer> stack;
    Stack<Integer> stack1;

    public MyQueue() {
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

package Design;

import java.util.ArrayDeque;
import java.util.Queue;

public class Implement_Stack_using_Queues {

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
        MyStackOneQueue myStack = new MyStackOneQueue();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }

}

class MyStackTwoQueues {

    Queue<Integer> stack;
    Queue<Integer> queue;

    public MyStackTwoQueues() {
        stack = new ArrayDeque<>();
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.add(x);

        while(!stack.isEmpty()) {
            queue.add(stack.poll());
        }

        Queue<Integer> temp = stack;
        stack = queue;
        queue = temp;
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }

        return stack.poll();
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }

        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}

class MyStackOneQueue {

    Queue<Integer> queue;

    public MyStackOneQueue() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        int size = queue.size();

        queue.add(x);

        for (int i = 0; i < size; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.poll();
    }

    public int top() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}


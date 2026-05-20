package LeetCode.Stacks.MonotonicStack;

import java.util.ArrayList;
import java.util.Stack;

public class Online_Stock_Span {



/*

StockSpannerBruteForce

TC (per call) : O(N) ~ where N is the number of elements currently stored in the list
TC (N calls) : O(N^2) ~ N times backward runs per element, for N-1 elements

SC : O(N) ~ adding element on each next call, no of adds = no of next calls

-------------------------------------------------
StockSpannerOptimal : Monotonic Stack with Previous greater element

TC (per call) : O(1)

1. It is pushed onto the stack exactly once during its own next() call.
2. It can be popped from the stack at most once when a larger element comes along.

TC (N calls) : O(N) ~ for N next calls

SC : O(N)

1. Worst case : [100, 80, 60, 40] :

If the prices are strictly decreasing, the while loop condition stack.peek()[0] <= price is never met.
No elements are ever popped, and the stack grows linearly with N.

2. Best Case : [10, 20, 30, 40]

If the prices are strictly increasing, on every next() it would pop smaller price.
The stack will never hold more than 1 or 2 elements at any given moment.

---------------------

StockSpannerMostOptimal: Monotonic Stack with Span Aggregation

TIME COMPLEXITY:
- Total (N calls): O(N)
- Per individual next() call: O(1) Amortized
1. Each price is turned into an array [price, span] and pushed onto the stack exactly once.
2. Each element is popped from the stack at most once when a larger price arrives.
3. Even if a single call pops multiple elements, those elements are gone forever and
will never be processed again in future calls.

SPACE COMPLEXITY:
- Worst Case: O(N)
- Occurs when prices are strictly decreasing (e.g., [100, 80, 60, 40]).
- The while loop condition `st.peek()[0] <= price` is never true, so no elements
are ever popped. The stack grows linearly with the number of calls.

- Best Case: O(1)
- Occurs when prices are strictly increasing (e.g., [10, 20, 30, 40]).
- Every incoming price is larger than the previous, completely flattening the stack
by popping the top element and absorbing its span.
- The stack never holds more than 1 element at the end of any `next()` call.


 */

    public static void main(String[] args) {

        StockSpannerMostOptimal stockSpanner = new StockSpannerMostOptimal();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));

    }

}



class StockSpannerBruteForce {

    ArrayList<Integer> list;
    public StockSpannerBruteForce() {
        list = new ArrayList<>();
    }

    public int next(int price) {

        int n = list.size(), right = n-1;
        int count = 1;

        while (right >= 0) {
            int curr = list.get(right);
            if (curr <= price) {
                count++;
            }
            else {
                break; // because we need consecutive days
            }
            right--;
        }

        list.add(price);

        return count;
    }


}
class StockSpannerOptimal {

    Stack<int[]> stack;
    int indx;

    public StockSpannerOptimal() {
        stack = new Stack<>();
        indx = -1;
    }

    public int next(int price) {

        indx += 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            stack.pop();
        }

//        if empty indx - (-1) = all element count till 0, else from indx to prev greater element
        int res = indx - (stack.isEmpty() ? -1 : stack.peek()[1]);

        stack.push(new int[]{price, indx});

        return res;
    }


}


class StockSpannerMostOptimal {

    private Stack<int[]> stack;
    public StockSpannerMostOptimal() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[]{price, span});

        return span;
    }

}


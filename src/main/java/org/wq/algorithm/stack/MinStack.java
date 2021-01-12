package org.wq.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    Deque<Integer> date = new ArrayDeque<>();
    Deque<Integer> mins = new ArrayDeque<>();

    MinStack() {
        // do initialization if necessary
    }

    void push(int number) {
        // write your code here
        date.push(number);
        if (mins.size() ==0 || mins.peek() >=number) {
            mins.push(number);
        } else {
            mins.push(mins.peek());
        }
    }

    int pop() {
        // write your code here
        if (mins.size()>0 && date.size() > 0) {
            int t = date.peek();
            date.pop();
            mins.pop();
            return t;
        }
        return 0;
    }

    int min() {
        // write your code here
        if (mins.size() > 0 && date.size() > 0)
            return mins.peek();
        return 0;

    }

    public static void main(String[] args) {

        MinStack ms = new MinStack();

        ms.push(1);
        System.out.println(ms.min());
        ms.pop();
        ms.push(2);
        System.out.println(ms.min());
        ms.push(3);
        System.out.println(ms.min());
        ms.push(1);
        System.out.println(ms.min());
    }

}

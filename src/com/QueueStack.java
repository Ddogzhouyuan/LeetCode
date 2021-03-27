package com;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStack {
    private Queue<Integer> queue = new LinkedList<>();
    private int topNum;

    public void push(int x) {
        queue.add(x);
        topNum = x;
    }

    public int peek() {
        return topNum;
    }

    public int pop() {
        int size = queue.size();
        while (size > 2) {
            queue.add(queue.poll());
            size--;
        }
        topNum = queue.peek();
        queue.add(queue.poll());
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

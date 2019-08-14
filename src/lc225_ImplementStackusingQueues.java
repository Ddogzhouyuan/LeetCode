import java.util.ArrayDeque;
import java.util.Queue;

public class lc225_ImplementStackusingQueues {
    static class MyStack {
        Queue<Integer> queue1;
        Queue<Integer> queue2;
        Queue<Integer> temp;
        /** Initialize your data structure here. */
        public MyStack() {
            queue1 = new ArrayDeque<>();
            queue2 = new ArrayDeque<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue1.offer(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int result = 0;
            while (queue1.size() > 1) queue2.offer(queue1.poll());
            result = queue1.poll();
            temp = queue1;
            queue1 = queue2;
            queue2 = temp;
            return result;
        }

        /** Get the top element. */
        public int top() {
            int result = 0;
            while (queue1.size() > 1) queue2.offer(queue1.poll());
            result = queue1.poll();
            queue2.offer(result);
            temp = queue1;
            queue1 = queue2;
            queue2 = temp;
            return result;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue1.size() == 0;
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());   // returns 2
        System.out.println(stack.pop());   // returns 2
        System.out.println(stack.empty()); // returns false
    }
}

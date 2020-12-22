package LeetCode_CN;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class lc_LCOF_09 {
    class CQueue {

        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            stack1.push(value);
        }

        public int deleteHead() {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            if (stack2.isEmpty()) {
                return -1;
            } else{
                return stack2.pop();
            }
        }
    }
}

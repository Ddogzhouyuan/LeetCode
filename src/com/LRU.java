package com;

import java.util.ArrayList;
import java.util.HashMap;

public class LRU {
    public static class Solution {

        public class Node {
            int key;
            int val;
            Node prev;
            Node next;
            public Node(int k, int v) {
                this.key = k;
                this.val = v;
            }
        }

        public class DoubleList {
            private int size;
            private Node head;
            private Node tail;

            public DoubleList() {
                this.head = new Node(0, 0);
                this.tail = new Node(0, 0);
                head.next = tail;
                tail.prev = head;
                this.size = 0;
            }

            public void addLast(Node x) {
                x.prev = tail.prev;
                x.next = tail;
                tail.prev.next = x;
                tail.prev = x;
                size++;
            }

            public void remove(Node x) {
                x.prev.next = x.next;
                x.next.prev = x.prev;
                size--;
            }

            public Node removeFirst() {
                if (head.next == tail) {
                    return null;
                }
                Node first = head.next;
                remove(first);
                return first;
            }

            public int size() {
                return this.size;
            }
        }

        private HashMap<Integer, Node> map;

        private DoubleList cache;

        private int capacity;

        private void makeRecently(int k) {
            Node x = map.get(k);
            cache.remove(x);
            cache.addLast(x);
        }

        private void addRecently(int k, int v) {
            Node x = new Node(k, v);
            cache.addLast(x);
            map.put(k, x);
        }

        private void deleteKey(int k) {
            Node x = map.get(k);
            cache.remove(x);
            map.remove(k);
        }

        private void removeLeastRecent() {
            Node x = cache.removeFirst();
            map.remove(x.key);
        }

        private int getF(int k) {
            if (map.containsKey(k)) {
                makeRecently(k);
                return map.get(k).val;
            } else {
                return -1;
            }
        }

        private void setF(int k, int v) {
            if (map.containsKey(k)) {
                deleteKey(k);
                addRecently(k, v);
                return;
            }
            if (cache.size == capacity) {
                removeLeastRecent();
            }
            addRecently(k, v);
        }

        public int[] LRU (int[][] operators, int k) {
            // write code here
            capacity = k;
            cache = new DoubleList();
            map = new HashMap<>();
            ArrayList<Integer> result = new ArrayList();
            int m = operators.length;
            for (int i = 0; i < m; i++) {
                int[] arr = operators[i];
                if (arr[0] == 1) {
                    setF(arr[1], arr[2]);
                }
                if (arr[0] == 2) {
                    result.add(getF(arr[1]));
                }
            }
            int n = result.size();
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = result.get(i);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[][] operators = {{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
        int cat = 3;
        Solution sol = new Solution();
        int[] result = sol.LRU(operators, cat);
        for (int i: result) {
            System.out.println(i);
        }
    }
}

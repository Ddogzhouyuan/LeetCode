package com;

public class MaxHeap<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxHeap(int cap) {
        pq = (Key[]) new Comparable[cap + 1];
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private int parent(int root) {
        return root / 2;
    }

    private int left(int root) {
        return root * 2;
    }

    private int right(int root) {
        return root * 2 + 1;
    }

    private void exchange(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public Key max() {
        return pq[1];
    }

    private void swim(int k) {
        while (k > 1 && less(parent(k), k)) {
            exchange(parent(k), k);
            k = parent(k);
        }
    }

    private void sink(int k) {
        while (left(k) < N) {
            int older = left(k);
            if (right(k) <= N && less(older, right(k))) {
                older = right(k);
            }
            if (less(older, k)) {
                break;
            }
            exchange(older, k);
            k = older;
        }
    }

    public void insert(Key e) {
        N++;
        pq[N] = e;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exchange(1, N);
        pq[N] = null;
        N--;
        sink(1);
        return max;
    }

}

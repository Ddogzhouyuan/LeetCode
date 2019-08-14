import java.util.Collections;
import java.util.PriorityQueue;

public class lc295_FindMedianfromDataStream_v2 {
    static class MedianFinder {
        PriorityQueue<Integer> q_reverse;
        PriorityQueue<Integer> q;

        /** initialize your data structure here. */
        public MedianFinder() {
            q_reverse = new PriorityQueue<>(Collections.reverseOrder());
            q = new PriorityQueue<>();
        }

        public void addNum(int num) {
            q_reverse.offer(num);
            q.offer(q_reverse.poll());
            if (q_reverse.size() < q.size()) q_reverse.offer(q.poll());
        }

        public double findMedian() {
            if (q_reverse.size() == q.size()) return (q_reverse.peek() + q.peek()) / 2.0;
            else return q_reverse.peek() / 1.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        double result = obj.findMedian();
        System.out.println(result);
        obj.addNum(3);
        result = obj.findMedian();
        System.out.println(result);
        obj.addNum(6);
        result = obj.findMedian();
        System.out.println(result);
    }
}

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class lc295_FindMedianfromDataStream {
    static class MedianFinder {
        List<Integer> numsOver100;
        int[] busket;

        /** initialize your data structure here. */
        public MedianFinder() {
            numsOver100 = new LinkedList<>();
            busket = new int[101];
        }

        public void addNum(int num) {
            if (num > 100) {
                numsOver100.add(num);
            } else {
                busket[num] += 1;
            }
        }

        public double findMedian() {
            int n = numsOver100.size() + IntStream.of(busket).sum();
            if (n == 1 && numsOver100.size() == 1){
                return (double) numsOver100.get(0);
            } else if (n == 1 && IntStream.of(busket).sum() == 1) {
                int index = 0;
                while (busket[index] == 0) index++;
                return (double) index;
            }
            Collections.sort(numsOver100);
            if (n % 2 == 1) {
                int mid = n / 2 + 1;
                int cnt_ = 0;
                int idx = 0;
                double result = 0;
                while (cnt_ < mid && idx <= 100) {
                    cnt_ += busket[idx++];
                }
                idx--;
                if (idx == 101 && cnt_ < mid) {
                    int j = 0;
                    while (cnt_ < mid) {
                        cnt_++;
                        j++;
                    }
                    idx = numsOver100.get(j);
                }
                result = (double) idx;
                return result;
            } else {
                int mid1 = n / 2;
                int mid2 = n / 2 + 1;
                int cnt_ = 0;
                int idx1 = 0;
                while (cnt_ < mid1 && idx1 <= 100) {
                    cnt_ += busket[idx1++];
                }
                int idx2 = idx1;
                idx1--;
                while (cnt_ < mid2 && idx2 <= 100) {
                    cnt_ += busket[idx2++];
                }
                idx2--;
                if (cnt_ == mid1) {
                    idx2 = numsOver100.get(0);
                }
                if (idx1 == 100 && cnt_ < mid1) {
                    int j = 0;
                    while (cnt_ < mid1) {
                        cnt_++;
                        j++;
                    }
                    idx1 = numsOver100.get(j - 1);
                    idx2 = numsOver100.get(j);
                }
                double result = (double) (idx1 + idx2) / 2;
                return result;
            }
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

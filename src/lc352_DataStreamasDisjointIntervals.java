import java.util.*;

public class lc352_DataStreamasDisjointIntervals {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    static class SummaryRanges {
        TreeSet<Integer> num_ls;
        List<Interval> result;

        /** Initialize your data structure here. */
        public SummaryRanges() {
            num_ls = new TreeSet<>();
            result = new LinkedList<>();
        }

        public void addNum(int val) {
            num_ls.add(val);
        }

        public List<Interval> getIntervals() {
            result = new LinkedList<>();
            if (num_ls.size() <= 1) {
                result.add(new Interval(num_ls.first(), num_ls.first()));
                return result;
            }
            int[] temp = new int[num_ls.size()];
            int j = 0;
            Iterator iterator = num_ls.iterator();
            while (iterator.hasNext()) {
                temp[j++] = (int) iterator.next();
            }
            Arrays.sort(temp);
            Interval interval_tmp = new Interval(temp[0], temp[0]);
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] <= interval_tmp.end) {
                    if (i == temp.length - 1) result.add(interval_tmp);
                    continue;
                } else if (temp[i] == interval_tmp.end + 1) {
                    interval_tmp = new Interval(interval_tmp.start, temp[i]);
                    if (i == temp.length - 1) result.add(interval_tmp);
                } else {
                    result.add(interval_tmp);
                    interval_tmp = new Interval(temp[i], temp[i]);
                    if (i == temp.length - 1) result.add(interval_tmp);
                }
            }
            return result;
        }
    }

    static void print_intervals(List<Interval> result) {
        for (Interval i: result) {
            int[] temp = new int[2];
            temp[0] = i.start;
            temp[1] = i.end;
            System.out.println(Arrays.toString(temp));
        }
    }

    public static void main(String[] args) {
        SummaryRanges obj = new SummaryRanges();
        obj.addNum(1);
        List<Interval> result = obj.getIntervals();
        print_intervals(result);
        System.out.println("-------------");
        obj.addNum(3);
        result = obj.getIntervals();
        print_intervals(result);
        System.out.println("-------------");
        obj.addNum(7);
        result = obj.getIntervals();
        print_intervals(result);
        System.out.println("-------------");
        obj.addNum(2);
        result = obj.getIntervals();
        print_intervals(result);
        System.out.println("-------------");
        obj.addNum(6);
        result = obj.getIntervals();
        print_intervals(result);
        System.out.println("-------------");
        obj.addNum(2);
        result = obj.getIntervals();
        print_intervals(result);
        System.out.println("-------------");
    }
}

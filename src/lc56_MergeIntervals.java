import java.util.*;

public class lc56_MergeIntervals {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    static class Solution {
        public List<Interval> merge(List<Interval> intervals) {
            if (intervals.size() <= 1) return intervals;
            Collections.sort(intervals, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    if (o1.start < o2.start) return -1;
                    else if (o1.start > o2.start) return 1;
                    else return 0;
                }
            });
            List<Interval> result = new LinkedList<>();
            Interval temp = new Interval(intervals.get(0).start, intervals.get(0).end);
            for (int i = 0; i < intervals.size(); i++) {
                if (isCover(intervals.get(i), temp)) {
                    temp = new Interval(Math.min(temp.start, intervals.get(i).start), Math.max(temp.end, intervals.get(i).end));
                    if (i == intervals.size() - 1) result.add(temp);
                    continue;
                } else {
                    result.add(temp);
                    temp = new Interval(intervals.get(i).start, intervals.get(i).end);
                    if (i == intervals.size() - 1) result.add(temp);
                }
            }
            return result;
        }

        public boolean isCover(Interval interval1, Interval newInterval) {
            if (interval1.start <= newInterval.start && interval1.end >= newInterval.start && interval1.end <= newInterval.end) {
                return true;
            } else if (newInterval.start <= interval1.start && newInterval.end >= interval1.start && interval1.end >= newInterval.end) {
                return true;
            } else if (newInterval.start >= interval1.start && newInterval.end <= interval1.end) {
                return true;
            } else if (newInterval.start <= interval1.start && newInterval.end >= interval1.end) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        List<Interval> intervals = new LinkedList<>();
        intervals.add(new Interval(2, 3));
        intervals.add(new Interval(4, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 9));
        intervals.add(new Interval(1, 10));
        Solution tool = new Solution();
        List<Interval> result = tool.merge(intervals);
        for (Interval i: result) {
            int[] temp = new int[2];
            temp[0] = i.start;
            temp[1] = i.end;
            System.out.println(Arrays.toString(temp));
        }

    }
}

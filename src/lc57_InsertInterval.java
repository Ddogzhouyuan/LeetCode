import java.util.*;

public class lc57_InsertInterval {
    public static class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
    }

    static class Solution {
        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            List<Interval> result = new LinkedList<Interval>();
            Interval temp = new Interval(newInterval.start, newInterval.end);
            int j = 0;
            while (j < intervals.size() && !isCover(intervals.get(j), newInterval)) {
                result.add(intervals.get(j));
                j++;
            }
            while (j < intervals.size() && isCover(intervals.get(j), temp)) {
                temp = new Interval(Math.min(intervals.get(j).start, temp.start), Math.max(intervals.get(j).end, temp.end));
                j++;
            }
            result.add(temp);
            while (j < intervals.size() && !isCover(intervals.get(j), newInterval)) {
                result.add(intervals.get(j));
                j++;
            }
            Collections.sort(result, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    if (o1.start < o2.start) return -1;
                    else if (o1.start > o2.start) return 1;
                    else return 0;
                }
            });
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
        intervals.add(new Interval(1, 2));
//        intervals.add(new Interval(3, 5));
//        intervals.add(new Interval(6, 7));
//        intervals.add(new Interval(8, 10));
//        intervals.add(new Interval(12, 16));
        Interval newInterval = new Interval(0, 0);
        Solution tool = new Solution();
        List<Interval> result = tool.insert(intervals, newInterval);
        for (Interval i: result) {
            int[] temp = new int[2];
            temp[0] = i.start;
            temp[1] = i.end;
            System.out.println(Arrays.toString(temp));
        }

    }


}

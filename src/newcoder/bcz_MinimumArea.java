package newcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bcz_MinimumArea {
    public static class Point {
        double x;
        double y;
        public Point(double val_x, double val_y) {
            x = val_x;
            y = val_y;
        }
    }

    static double dis(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    static double xmulti(Point p1, Point p2, Point p0) {
        //求p1p0和p2p0的叉积,如果大于0,则p1在p2的顺时针方向
        return (p1.x - p0.x) * (p2.y - p0.y) - (p2.x - p0.x) * (p1.y - p0.y);
    }

    static Point[] graham(Point[] ps, int n) {
        int t = 0;
        for (int i = 0; i < n; i++) {
            if (ps[i].y < ps[t].y) {
                t = i;
            }
        }
        List<Integer> pl = new ArrayList<>();
        pl.add(Integer.valueOf(t));
        int num = 0;
        do {
            num++;
            t = pl.get(num - 1) + 1;
            if (t >= n) t = 0;
            for (int i = 0; i < n; i++) {
                double x = xmulti(ps[i], ps[t], ps[pl.get(num - 1)]);
                if (x < 0) t = i;
            }
            pl.add(num, t);
        } while (pl.get(num) != pl.get(0));
        Point[] result = new Point[num];
        for (int i = 0; i < num ; i++) {
            result[i] = ps[pl.get(i)];
        }
        return result;
    }

    static double getS(Point a, Point b, Point c) {
        return ((b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x)) / 2;
    }

    static double getPS(Point[] result) {
        double sum = 0;
        for (int i = 1; i < result.length - 1; i++) {
            sum += Math.abs(getS(result[0], result[i], result[i + 1]));
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Point[] ps = new Point[n];
        for (int i = 0; i < n; i++) {
            String[] temp = sc.nextLine().split(" ");
            ps[i] = new Point(Double.parseDouble(temp[0]), Double.parseDouble(temp[1]));
        }
        if (n <= 3) {
            double result = getPS(ps);
            System.out.println(result);
        } else {
            Point[] edgePoints = graham(ps, n);
            double result = getPS(edgePoints);
            System.out.println(result);
        }
    }
}

package newcoder;

import java.util.Scanner;

public class bcz_clique_rotate {
    public static double[] rotateAngle(String starttime, String endtime) {
        double[] result = new double[3];
        String[] start = starttime.split(":");
        String[] end = endtime.split(":");
        int seconds = 0;
        seconds += (Integer.parseInt(end[0]) - Integer.parseInt(start[0])) * 3600;
        seconds += (Integer.parseInt(end[1]) - Integer.parseInt(start[1])) * 60;
        seconds += (Integer.parseInt(end[2]) - Integer.parseInt(start[2]));
        result[2] = seconds * 6;
        result[1] = seconds / 10;
        result[0] = seconds / 120;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String starttime = sc.next();
        String endtime = sc.next();
        double[] result = rotateAngle(starttime, endtime);
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
    }
}

package newcoder;

import java.util.Scanner;

public class bcz_BCON {
    public static String BCONsearch(String bcon, String keys) {
        if (bcon.length() <= 2) return null;
        String[] bcon_ls = bcon.substring(1, bcon.length() - 1).split(";");
        String[] keySet = new String[bcon_ls.length];
        String[] valueSet = new String[bcon_ls.length];
        for (int i = 0; i < bcon_ls.length; i++) {
            int splitIndex = bcon_ls[i].indexOf("->");
            keySet[i] = bcon_ls[i].substring(0, splitIndex);
            valueSet[i] = bcon_ls[i].substring(splitIndex + 2);
        }
        return "";
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bcon = sc.nextLine();
        String keys = sc.nextLine();

    }
}

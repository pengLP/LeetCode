package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main5 {

    private static List<Integer> getPath(int x) {
        List<Integer> path = new ArrayList<>();
        while (x != 1) {
            path.add(x / 2);
            x/=2;
        }
        return path;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for (int k = 0;k < num; k++) {
            int x = in.nextInt() , s = in.nextInt();
            if (s == 0 || x == 0){
                System.out.println(-1);
                continue;
            }
            List<Integer> path = getPath(x);
            if (s <= path.size())
                System.out.println(path.get(path.size() - s));
            else
                System.out.println(-1);
        }

    }
}

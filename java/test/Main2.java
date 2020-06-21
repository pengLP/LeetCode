package test;

import bishi.Main;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int k = 0; k < n; k++) {
            double res = Double.MAX_VALUE;
            int num = in.nextInt();
            int A[][] = new int[num][2];
            int B[][] = new int[num][2];
            for (int i = 0; i < A.length; i++) {
                A[i][0] = in.nextInt();
                A[i][1] = in.nextInt();
            }
            for (int i = 0; i < B.length; i++) {
                B[i][0] = in.nextInt();
                B[i][1] = in.nextInt();
            }

            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B.length; j++) {
                    res = Math.min(res, getInstance(A[i][0], A[i][1], B[j][0], B[j][1]));
                }
            }
            String douStr = String.format("%.3f", res);
            System.out.println(douStr);
        }
    }

    private static double getInstance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }


}

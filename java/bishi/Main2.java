package bishi;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt() , m=in.nextInt(), k=in.nextInt();
        int num[] = new int[n];
        for (int i = 0;i < num.length;i++) {
            num[i] = in.nextInt();
        }
        for (int i = 0;i < m; i++) {
            int max = 0 , maxIndex = -1;
            for (int j = 0;j < num.length; j++) {
                num[j] = k + num[j];
                if (num[j] > max) {
                    max = num[j];
                    maxIndex = j;
                }
            }
            num[maxIndex] /= 2;
        }
        int sum = 0;
        for (int i = 0;i < num.length; i++){
            sum += num[i];
        }
        System.out.println(sum);
    }
}

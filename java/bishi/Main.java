package bishi;

import java.text.DecimalFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nums[] = new int[n];
        for (int i = 0;i < nums.length; i++) {
            nums[i] = in.nextInt();
        }
        double sum = 0,num = 0;
        for (int i = 0;i < nums.length; i++) {
            for (int j = i;j < nums.length; j++) {
                int max = 0;
                for (int k = i;k <= j;k++){
                    max = Math.max(max , nums[k]);
                }
                sum += max;
                num++;
            }
        }
        DecimalFormat df = new DecimalFormat("#0.000000");
        System.out.println(df.format(sum/num));
    }

}

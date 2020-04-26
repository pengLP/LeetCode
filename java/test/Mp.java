package test;

import java.util.Arrays;
import java.util.Scanner;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Mp
{

    public static void main(String[] args) {
        int num[] = new int[]{1,2,3,4,5,6,7,8,9,10};
        int txt = 0;
        for (int i = 0;i < num.length -1 ; i++) {
            boolean flag = false;
            for (int j = 0;j < num.length -1 -i ; j++) {
                txt++;
                System.out.println(num[j] +"    "+ num[j + 1]);
                if (num[j] > num[j + 1]) {
                    int t = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = t;
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
        System.out.println(txt);
        System.out.println(Arrays.toString(num));
    }

}
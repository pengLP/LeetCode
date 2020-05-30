package test;

import java.util.Arrays;
import java.util.Scanner;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Mp
{

    static int fun(int n) {
        int f1 = 1, f2 = 1, f = f1+f2;
        while (f < n) {
            f1 = f2;
            f2 = f;
            f = f1 + f2;
        }
        return f;
    }

    public static void main(String[] args) {

        float x = 2 , y;
        if (x < 0)
            y = 0;
        else if(x < 5 && x == 0)
            y = 1/(x + 2);
        else if (x < 10)
            y = 1/x;
        else y = 10;
        System.out.println(y);
    }

}
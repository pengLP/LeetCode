package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0;i < n; i++) {
            String str = in.next();
            if (bh(str).equals("")) {
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }

    public static String bh(String str) {
        int n = str.length();
        if (n <= 0) {
            return "";
        }
        char x[] = str.toCharArray();
        Character dest[] = new Character[n];
        for (int i = 0;i < x.length; i++) {
            dest[i] = Character.valueOf(x[i]);
        }
        List<Character> list = new ArrayList<>(Arrays.asList(dest));
        boolean hdl = true;
        while (hdl) {
            int bsize = list.size();
            for (int i = 0;i < list.size() - 1; i++) {
                if (list.get(i) == list.get(i + 1)) {
                    list.remove(i);
                    list.remove(i);
                    break;
                }
            }
            int esize = list.size();
            if (bsize == esize) {
                hdl = false;
            }else {
                hdl = true;
            }
        }
        StringBuffer sbf = new StringBuffer();
        for (int i = 0;i < list.size(); i++) {
            sbf.append(list.get(i));
        }
        return sbf.toString();
    }

}

package byteCam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2048 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] x = new int[4][4];
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                x[i][j] = sc.nextInt();
            }
        }
        String a = sc.next();
        find(x, a);
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void find(int[][] x, String a) {
        switch (a) {
            case "w":
                for (int i = 0; i < x.length; i++) {
                    List<Integer> list = new ArrayList<>();
                    for (int j = 0; j < x[i].length; j++) {
                        if (x[i][j] != 0)
                            list.add(x[i][j]);
                    }
                    for (int j = 0; j < list.size() - 1; j++) {
                        if (list.get(j) == list.get(j + 1)) {
                            int num = list.get(j) * 2;
                            list.remove(j);
                            list.remove(j);
                            list.add(j, num);
                        }
                    }

                    for (int j = 0; j < list.size(); j++) {
                        x[i][j] = list.get(j);
                    }
                    for (int j = list.size(); j < x[i].length; j++) {
                        x[i][j] = 0;
                    }
                }
                break;
            case "s":
                for (int i = 0; i < x.length; i++) {
                    List<Integer> list = new ArrayList<>();
                    for (int j = 0; j < x[i].length; j++) {
                        if (x[i][j] != 0)
                            list.add(x[i][j]);
                    }
                    for (int j = list.size() - 1; j > 0; j--) {
                        if (list.get(j) == list.get(j - 1)) {
                            int num = list.get(j) * 2;
                            list.remove(j - 1);
                            list.remove(j - 1);
                            if (j == list.size())
                                list.add(num);
                            else
                                list.add(j - 1, num);
                        }
                    }
                    int j = x[i].length - 1;
                    for (int k = list.size() - 1; k >= 0; k--) {
                        x[i][j] = list.get(k);
                        j--;
                    }
                    while (j >= 0) {
                        x[i][j] = 0;
                        j--;
                    }
                }
                break;
            case "a":
                for (int j = 0; j < x[0].length; j++) {
                    List<Integer> list = new ArrayList<>();
                    for (int i = 0; i < x.length; i++) {
                        if (x[i][j] != 0)
                            list.add(x[i][j]);
                    }
                    for (int i = 0; i < list.size() - 1; i++) {
                        if (list.get(i) == list.get(i + 1)) {
                            int num = list.get(i) * 2;
                            list.remove(i);
                            list.remove(i);
                            list.add(i, num);
                        }
                    }

                    for (int i = 0; i < list.size(); i++) {
                        x[i][j] = list.get(i);
                    }
                    for (int i = list.size(); i < x.length; i++) {
                        x[i][j] = 0;
                    }
                }
                break;
            case "d":
                for (int j = 0; j < x[0].length; j++) {
                    List<Integer> list = new ArrayList<>();
                    for (int i = 0; i < x.length; i++) {
                        if (x[i][j] != 0)
                            list.add(x[i][j]);
                    }
                    for (int i = list.size() - 1; i > 0; i--) {
                        if (list.get(i) == list.get(i - 1)) {
                            int num = list.get(i) * 2;
                            list.remove(i - 1);
                            list.remove(i - 1);
                            if (i == list.size()) {
                                list.add(num);
                            } else {
                                list.add(i - 1, num);
                            }
                        }
                    }

                    int i = x.length - 1;
                    for (int k = list.size() - 1; k >= 0; k++) {
                        x[i][j] = list.get(k);
                    }
                    while (i >= 0) {
                        x[i][j] = 0;
                    }
                }

                break;
        }
    }

}

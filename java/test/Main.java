package test;

import javax.print.DocFlavor;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;

public class Main {

    private static boolean bfs(int path[][]) {
        int N = path.length - 1;
        boolean visit[] = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            visit[index] = true;
            for (int i = 1;i <= N; i++) {
                if (!visit[i] && path[index][i] == 1) {
                    queue.add(i);
                }
            }
            for (int i = 1;i < visit.length; i++) {
                if (!visit[i])
                    return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int  N = in.nextInt() , M = in.nextInt();
        int path[][] = new int[N+1][N+1];
        for (int i = 1;i <= N; i++) {
            path[i][i] = 1;
        }
        for (int i = 0;i < M; i++) {
            int start = in.nextInt() , end = in.nextInt();
            path[start][end] = 1;
            path[end][start] = 1;
        }
        if (N > M+1){
            System.out.println("NO");
            return;
        }

        if (bfs(path)) {
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }


    }

}

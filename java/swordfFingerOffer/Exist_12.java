package swordfFingerOffer;

import javax.swing.*;
import java.util.Stack;

/**
 * 面试题12. 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * */

class Node {
    int x;
    int y;
    public Node(int x,int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class Exist_12 {

    public static boolean exist(char[][] board, String word) {
        if (board == null || board[0] == null)
            return false;
        if (word == null || word.length() == 0)
            return true;
        if(board.length * board[0].length < word.length())
            return false;

        char c[] = word.toCharArray();
        for (int i = 0;i < board.length; i++) {
            for (int j = 0;j < board[i].length; j++) {
                if (bfs(board , i,j,c,0))
                    return true;
            }
        }
        return false;
    }

    public static boolean bfs(char[][] board , int x,int y,char c[],int k) {

        if (board.length <= x || x < 0 || board[0].length <= y || y < 0 || board[x][y] != c[k])
            return false;
        boolean visit[][] = new boolean[board.length][board[0].length];
        boolean flg = true;
        Stack<Node> stack = new Stack<Node>();
        stack.push(new Node(x,y));
        visit[x][y] = true;
        k = 1;
        System.out.println("=============");
        while (stack.size() != 0) {
            if (c.length == 1)
                return true;
            Node cur = stack.peek();
            if (cur.x-1 >= 0 && !visit[cur.x-1][cur.y] && board[cur.x-1][cur.y] == c[k]) {
                System.out.println("上移");
                stack.push(new Node(cur.x-1,cur.y));
                visit[cur.x-1][cur.y] = true;
                ++k;
                flg = true;
                // 找到了符合要求的路径，则返回 true
                if (k == c.length) return true;
            }else if (cur.y-1 >= 0 && !visit[cur.x][cur.y-1] && board[cur.x][cur.y-1] == c[k]){
                System.out.println("左移");
                stack.push(new Node(cur.x,cur.y-1));
                visit[cur.x][cur.y-1] = true;
                flg = true;
                ++k;
                // 找到了符合要求的路径，则返回 true
                if (k == c.length) return true;
            }else if (cur.x+1 <board.length && !visit[cur.x+1][cur.y] && board[cur.x+1][cur.y] == c[k]) {
                System.out.println("下移");
                stack.push(new Node(cur.x+1 , cur.y));
                visit[cur.x+1][cur.y] = true;
                flg = true;
                ++k;
                // 找到了符合要求的路径，则返回 true
                if (k == c.length) return true;
            }else if (cur.y+1 <board[0].length && !visit[cur.x][cur.y+1] && board[cur.x][cur.y+1] == c[k]) {
                System.out.println("右移");
                stack.push(new Node(cur.x,cur.y+1));
                visit[cur.x][cur.y+1] = true;
                flg = true;
                ++k;
                // 找到了符合要求的路径，则返回 true
                if (k == c.length) return true;
            }else {

                Node tmp = stack.pop();
                if (flg){
                    k--;
                    flg = false;

                }
                System.out.println("回退   " + board[tmp.x][tmp.y] + "    " + c[k] + "   "
                +(cur.y+1 <board[0].length && !visit[cur.x][cur.y+1] && board[cur.x][cur.y+1] == c[k]));
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        char c1[][] = new char[][]{{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','f'}};
        System.out.println(exist(new char[][]{{'a','b','c','e'},{'s','f','e','s'},{'a','d','e','e'}},"abceseeefs"));

    }

}

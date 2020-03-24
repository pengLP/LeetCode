package bfs;

import java.util.*;

/**
 * 365. 水壶问题
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * 你允许：
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * */
class Node{
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x &&
                y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
public class CanMeasureWater_365 {

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0)
            return true;
        if (x + y < z)
            return false;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0 , 0));
        Set<Node> set = new HashSet<>();
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            if (set.contains(n))
                continue;
            int remain_x = n.x;
            int remain_y = n.y;
            if (remain_x == z || remain_y == z || remain_x + remain_y == z)
                return true;
            set.add(n);
            queue.add(new Node(x ,remain_y));
            queue.add(new Node(remain_x , y));
            queue.add(new Node(0 , remain_y));
            queue.add(new Node(remain_x , 0));
            queue.add(new Node(remain_x - Math.min(remain_x , y - remain_y) ,remain_y + Math.min(remain_x , y - remain_y)));
            queue.add(new Node(remain_x + Math.min(x - remain_x , remain_y) , remain_y - Math.min(x - remain_x , remain_y)));
        }

        return false;
    }

    public static void main(String[] args) {
        CanMeasureWater_365 canMeasureWater_365 = new CanMeasureWater_365();
        System.out.println(canMeasureWater_365.canMeasureWater(2,6,5));
    }

}

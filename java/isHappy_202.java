import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * 编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * */
public class isHappy_202 {

    public boolean isHappy(int n) {
        if (n == 1) return true;
        Set<Integer> set = new HashSet<>();
        while (true) {
            if (set.contains(n))
                return false;
            else
                set.add(n);
            if (n == 1) return true;
            n = getSumSquare(n);
        }
    }

    private int getSumSquare(int n) {
        int res = 0;
        while (n != 0) {
            res += Math.pow((n % 10),2);
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        isHappy_202 isHappy_202 = new isHappy_202();
        System.out.println(isHappy_202.isHappy(19));
    }

}

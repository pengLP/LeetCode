package BinarySearch;

/**
 * 猜数字大小
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 */
public class GuessNumber {
    public static int guess(int num) {
        int n = 6;
        if (num == n)
            return 0;
        if (num > n)
            return -1;
        return 1;
    }

    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0)
                return mid;
            if (guess(mid) == -1)
                right = mid - 1;
            if (guess(mid) == 1)
                left = mid + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        GuessNumber s = new GuessNumber();
        System.out.println(s.guessNumber(10));
    }
}

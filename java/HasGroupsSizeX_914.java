
/**
 * 914. 卡牌分组
 * 给定一副牌，每张牌上都写着一个整数。
 * <p>
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * <p>
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 */
public class HasGroupsSizeX_914 {


    private int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        int count[] = new int[10000];
        for (int i = 0; i < deck.length; i++) {
            count[deck[i]]++;
        }
        int ans = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (ans == -1) {
                    ans = count[i];
                } else {
                    ans = gcd(ans, count[i]);
                }
            }
        }

        return ans >= 2;
    }

    public static void main(String[] args) {
        HasGroupsSizeX_914 hasGroupsSizeX_914 = new HasGroupsSizeX_914();
        System.out.println(hasGroupsSizeX_914.gcd(3, 4));
    }
}

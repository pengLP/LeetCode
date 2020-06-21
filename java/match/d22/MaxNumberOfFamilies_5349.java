package match.d22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * 5349. 安排电影院座位 显示英文描述
 * <p>
 * 如上图所示，电影院的观影厅中有 n 行座位，行编号从 1 到 n ，且每一行内总共有 10 个座位，列编号从 1 到 10 。
 * <p>
 * 给你数组 reservedSeats ，包含所有已经被预约了的座位。比如说，researvedSeats[i]=[3,8] ，它表示第 3 行第 8 个座位被预约了。
 * <p>
 * 请你返回 最多能安排多少个 4 人家庭 。4 人家庭要占据 同一行内连续 的 4 个座位。隔着过道的座位（比方说 [3,3] 和 [3,4]）不是连续的座位，但是如果你可以将 4 人家庭拆成过道两边各坐 2 人，这样子是允许的。
 */
public class MaxNumberOfFamilies_5349 {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        boolean seat[] = new boolean[11];

        int ans = n * 2;
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i <= reservedSeats.length - 1; i++) {
            int x = reservedSeats[i][0];
            int y = reservedSeats[i][1];
            if (map.containsKey(x))
                map.get(x).add(y - 1);
            else {
                map.put(x, new ArrayList<>());
                map.get(x).add(y - 1);
            }
        }
        for (Integer i : map.keySet()) {
            List<Integer> list = map.get(i);
            if (list.contains(5) && list.contains(6)) {
                ans -= 2;
                continue;
            } else if (list.contains(5) && !list.contains(6)) {
                if (!list.contains(6) && !list.contains(7) && !list.contains(8) && !list.contains(9))
                    ans -= 1;
                else
                    ans -= 2;
            } else if (list.contains(6) && !list.contains(5)) {
                if (!list.contains(5) && !list.contains(2) && !list.contains(3) && !list.contains(4))
                    ans -= 1;
                else
                    ans -= 2;
            } else {
                boolean flag1 = false;
                boolean flag2 = false;
                boolean flag3 = false;
                if (!list.contains(5) && !list.contains(4) && !list.contains(3) && !list.contains(2)) flag1 = true;
                if (!list.contains(4) && !list.contains(5) && !list.contains(6) && !list.contains(7)) flag2 = true;
                if (!list.contains(6) && !list.contains(7) && !list.contains(8) && !list.contains(9)) flag3 = true;
                //flag1:true:可行，false：不可行
                if (flag1 && flag2 && flag3) {
                    continue;
                } else if (flag1 && flag2 && !flag3) {
                    ans -= 1;
                    continue;
                } else if (flag1 && !flag2 && flag3) {
                    continue;
                } else if (flag1 && !flag2 && !flag3) {
                    ans -= 1;
                    continue;
                } else if (!flag1 && flag2 && flag3) {
                    ans -= 1;
                    continue;
                } else if (!flag1 && flag2 && !flag3) {
                    ans -= 1;
                    continue;
                } else if (!flag1 && !flag2 && flag3) {
                    ans -= 1;
                    continue;
                } else if (!flag1 && !flag2 && !flag3) {
                    ans -= 2;
                    continue;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxNumberOfFamilies_5349 maxNumberOfFamilies_5349 = new MaxNumberOfFamilies_5349();
    }

}

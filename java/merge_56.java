import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 */
public class merge_56 {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2)
            return intervals;

        Arrays.sort(intervals, Comparator.comparing(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curInterval = intervals[i];
            int[] peek = res.get(res.size() - 1);

            if (curInterval[0] > peek[1]) {
                res.add(curInterval);
            } else {
                peek[1] = Math.max(curInterval[1], peek[1]);
            }


        }


        return res.toArray(new int[res.size()][]);
    }


}

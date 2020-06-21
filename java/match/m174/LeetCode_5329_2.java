package match.m174;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

/**
 * 5329. 数组大小减半 显示英文描述
 * 用户通过次数645
 * 用户尝试次数691
 * 通过次数651
 * 提交次数938
 * 题目难度Medium
 * 给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
 * <p>
 * 返回 至少 能删除数组中的一半整数的整数集合的最小大小。
 */
public class LeetCode_5329_2 {

    public int minSetSize(int[] arr) {
        int res = 0;
        int num = 0;
        int len = arr.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int s : arr) {
            Integer i = map.get(s);
            if (i == null)
                map.put(s, 1);
            else
                map.put(s, ++i);
        }

        map = sortDescend(map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            num += entry.getValue();
            res++;
            if (num >= len)
                return res;
        }
        return res;
    }

    // Map的value值降序排序
    public static <K, V extends Comparable<? super V>> Map<K, V> sortDescend(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                int compare = (o1.getValue()).compareTo(o2.getValue());
                return -compare;
            }
        });

        Map<K, V> returnMap = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            returnMap.put(entry.getKey(), entry.getValue());
        }
        return returnMap;
    }


    public static void main(String[] args) {
        LeetCode_5329_2 s = new LeetCode_5329_2();
        System.out.println(s.minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7}));
    }
}

package swordfFingerOffer;

import java.util.*;

public class Permutation_38 {

    public String[] permutation(String s) {
        if (s == null || s.length() == 0)
            return new String[]{""};
        int index = 0, end = s.length() - 1;
        Set<String> res = new HashSet<>();
        char c[] = s.toCharArray();
        getPermutation(res, index, end, c);
        return res.toArray(new String[0]);
    }

    private void getPermutation(Set<String> res, int index, int end, char[] arr) {
        if (arr == null || arr.length == 0)
            return;
        if (index == end) {
            res.add(new String(arr));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(i, index, arr);
            getPermutation(res, index + 1, end, arr);
            swap(i, index, arr);
        }
    }

    private void swap(int x, int y, char arr[]) {
        char t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        ListIterator<Integer> it = list.listIterator();//返回一个list接口中的特有迭代器
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }


}

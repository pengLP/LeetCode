package swordfFingerOffer;

import java.util.*;

public class GetLeastNumbers_40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        Queue<Integer> deque = new PriorityQueue<>((a1 , a2)->a1-a2);
        for (int i = 0;i < arr.length; i++) {
            deque.add(arr[i]);
        }
        int res[] = new int[k];
        for (int i = 0;i < k; i++) {
            res[i] = deque.poll();
        }
        return res;
    }

}

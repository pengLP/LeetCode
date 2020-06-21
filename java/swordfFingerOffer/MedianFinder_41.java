package swordfFingerOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 面试题41. 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class MedianFinder_41 {

    // count为奇数时进入小顶堆，为偶数时进入大顶堆
    private int count = 0;
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;


    public MedianFinder_41() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1 - integer;
            }
        });
    }

    public void addNum(int num) {
        if (count % 2 == 0) {
            maxHeap.offer(num);
            int tmp = maxHeap.poll();
            minHeap.offer(tmp);
        } else {
            minHeap.offer(num);
            int tmp = minHeap.poll();
            maxHeap.offer(tmp);
        }
        count++;
    }

    public double findMedian() {
        if (count % 2 == 0) {
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
        } else {
            return new Double(minHeap.peek());
        }
    }

    public static void main(String[] args) {
        MedianFinder_41 medianFinder_41 = new MedianFinder_41();
        int n[] = new int[]{1, 100, 2, 5, 12, 44, 88, 77, 54, 932, 61};
        for (int i = 0; i < n.length; i++) {
            medianFinder_41.addNum(n[i]);
        }
        System.out.println(medianFinder_41.findMedian());
    }


}

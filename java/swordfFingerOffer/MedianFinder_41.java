package swordfFingerOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 面试题41. 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * */
public class MedianFinder_41 {

    /** initialize your data structure here. */

    // count为奇数时进入小顶堆，为偶数时进入大顶堆
    private int count = 0;
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    /** initialize your data structure here. */
    public MedianFinder_41() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> {return b-a;});
    }

    public void addNum(int num) {
        if (count % 2 == 0) {
            maxHeap.offer(num);
            int tmp = maxHeap.poll();
            minHeap.offer(tmp);
        }else {
            minHeap.offer(num);
            int tmp = minHeap.poll();
            maxHeap.offer(tmp);
        }
        count++;
    }

    public double findMedian() {
        if(count %2 == 0){
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
        }else{
            return new Double(minHeap.peek());
        }
    }

    public static void main(String[] args) {
        MedianFinder_41 medianFinder_41 = new MedianFinder_41();
        medianFinder_41.addNum(10);
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        minHeap.add(6);
        minHeap.add(1);
        minHeap.add(8);
        System.out.println(minHeap.poll());
    }

}

import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 */
public class MedianFinder_295 {

    private PriorityQueue<Integer> minHeep;
    private PriorityQueue<Integer> maxHeap;
    private int count;

    public MedianFinder_295() {
        minHeep = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        count = 0;
    }

    public void addNum(int num) {

        if (count % 2 == 0) {
            minHeep.offer(num);
            int p = minHeep.poll();
            maxHeap.offer(p);
        } else {
            maxHeap.offer(num);
            int p = maxHeap.poll();
            minHeep.offer(p);
        }
        count++;
    }

    public double findMedian() {
        if (count % 2 == 0) {
            return new Double((minHeep.peek() + maxHeap.peek()) / 2);
        } else {
            return new Double(minHeep.peek());
        }
    }

}

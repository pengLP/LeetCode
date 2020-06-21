package tencent.px;

import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int n : nums) {
            queue.add(n);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }


}

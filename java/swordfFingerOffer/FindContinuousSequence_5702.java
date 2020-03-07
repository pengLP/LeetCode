package swordfFingerOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindContinuousSequence_5702 {

    public int[][] findContinuousSequence(int target) {
        if (target < 3)
            return null;
        int small = 1 , big = 2;
        int curr = small + big;
        List<int[]> res = new ArrayList<>();
        int middle = (target+1)>>>1;
        while (small < middle) {
            if (curr == target){
                int tmp[] = new int[big - small + 1];
                for (int i = small,j = 0;i <= big; i++,j++) {
                    tmp[j] = i;
                }
                res.add(tmp);
            }
            while (curr > target && small < middle) {
                curr -= small;
                small++;
                if (curr == target){
                    int tmp[] = new int[big - small + 1];
                    for (int i = small,j = 0;i <= big; i++,j++) {
                        tmp[j] = i;
                    }
                    res.add(tmp);
                }
            }
            big++;
            curr+=big;
        }

        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        FindContinuousSequence_5702 findContinuousSequence_5702 = new FindContinuousSequence_5702();
        System.out.println(findContinuousSequence_5702.findContinuousSequence(6));
    }
}

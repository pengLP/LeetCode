package swordfFingerOffer;

import java.util.Arrays;

public class GetLeastNumbers_40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr , 0 , k);
    }

}


/**
 * 1013. 将数组分成和相等的三个部分
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * <p>
 * 形式上，如果可以找出索引 i+1 < j 且
 * 满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
 * 就可以将数组三等分。
 */

public class CanThreePartsEqualSum_1013 {

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0)
            return false;
        int left = 0, right = A.length - 1;
        int leftSum = A[left], rightSum = A[right];
        int tmp = sum / 3;
        while (left + 1 < right) {
            if (leftSum == tmp && rightSum == tmp) {
                return true;
            }
            if (leftSum != tmp) {

                leftSum += A[++left];
            }

            if (rightSum != tmp) {
                rightSum += A[--right];
            }
        }
        return false;

    }

    public static void main(String[] args) {
        CanThreePartsEqualSum_1013 canThreePartsEqualSum_1013 = new CanThreePartsEqualSum_1013();
        System.out.println(canThreePartsEqualSum_1013.canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
    }
}

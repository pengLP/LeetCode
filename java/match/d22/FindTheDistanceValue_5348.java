package match.d22;

/**
 * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
 * 「距离值」 定义为符合此描述的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
 */
public class FindTheDistanceValue_5348 {


    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        boolean tmp = false;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    tmp = true;
                }
            }
            if (!tmp)
                ans++;
            tmp = false;
        }
        return ans;
    }

    public static void main(String[] args) {
        FindTheDistanceValue_5348 findTheDistanceValue_5348 = new FindTheDistanceValue_5348();
        System.out.println(findTheDistanceValue_5348.findTheDistanceValue(new int[]{4, 5, 8}, new int[]{10, 9, 1, 8}, 2));
    }
}

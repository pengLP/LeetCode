import java.util.Arrays;

public class FindBestValue_1300 {

    public int findBestValue(int[] arr, int target) {
        if (arr == null || arr.length == 0)
            return 0;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int sum = 0 , n = arr.length;
        for (int i = 0;i < n; i++) {
            int x = (target - sum) / (n - i);
            System.out.println(x);
            if (x < arr[i]) {
                double t = (double) (target - sum) / (n - i);
                if (t - x > 0.5) {
                    return x + 1;
                }else {
                    return x;
                }
            }
            sum +=  arr[i];
        }
        return arr[n - 1];
    }

    public static void main(String[] args) {
        FindBestValue_1300 findBestValue_1300 = new FindBestValue_1300();
        System.out.println(findBestValue_1300.findBestValue(new int[]{4,9,3}, 10));
    }
}

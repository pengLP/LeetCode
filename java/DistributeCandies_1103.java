

public class DistributeCandies_1103 {

    public int[] distributeCandies(int candies, int num_people) {
        int res[] = new int[num_people];
        int i = 0;
        while (candies > 0) {
            res[i % num_people] += Math.min(i + 1, candies);
            candies -= Math.min(i + 1, candies);
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        DistributeCandies_1103 distributeCandies_1103 = new DistributeCandies_1103();
        int res[] = distributeCandies_1103.distributeCandies(7, 4);
        for (Integer i : res) {
            System.out.println(i);
        }

    }
}

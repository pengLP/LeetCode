import java.util.ArrayList;
import java.util.List;

public class YangHuiTriangle_118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0)
            return res;
        res.add(new ArrayList<>());
        res.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = res.get(i - 1);

            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(preRow.get(j - 1) + preRow.get(j));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        YangHuiTriangle_118 yangHuiTriangle_118 = new YangHuiTriangle_118();
        List<List<Integer>> triangle = yangHuiTriangle_118.generate(5);
        for (List<Integer> row : triangle) {
            for (Integer i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}

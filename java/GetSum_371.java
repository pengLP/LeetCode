
/**
 * 371. 两整数之和
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 */
public class GetSum_371 {

    public int getSum(int a, int b) {
        while (b != 0) {
            int tmp = a ^ b;
            int curr = (a & b) << 1;
            a = tmp;
            b = curr;
        }
        return a;
    }

    public static void main(String[] args) {
        GetSum_371 getSum_371 = new GetSum_371();
        System.out.println(getSum_371.getSum(12, 7));
    }
}

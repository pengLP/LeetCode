package byteCam;

import java.util.Scanner;

/**
 * 题目描述：
 * 小明和安琪是好朋友。最近，他们的谈话被一家侦探机构监控，所以他们想将他们的谈话内容进行加密处理。
 * 于是，他们发明了一种新的加密方式。每条信息都被编译成二进制数B（明文），其长度为N。
 * 然后该信息被写下K次，每次向右移动0，1，...，K-1位。
 * 例如：B = 1001010，K=4
 * 1001010
 *  1001010
 *   1001010
 *    1001010
 * 然后对每一列进行异或操作，并且把最终所得的结果记录下来，我们将该数称为S（密文）。
 * 例如上述例子的结果为：1110100110。
 * 最后，将编码的信息S和K发送给安琪。
 * 小明已经实现了这种编码的加密过程，但他要求安琪写一个程序去实现这种编码的解密过程，你能帮助安琪实现解密过程吗？
 *
 * 输入描述：
 * 第一行输入两个整数 N 和 K
 *
 * 第二行输入一个二进制字符串S，长度是N + K - 1
 * */
public class Q20200219 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N =in.nextInt() , K = in.nextInt();
        String S = in.next();
        int S1[] = new int[N+K-1];
        int res[] = new int[N];
        for (int i = 0;i < S.length(); i++) {
            S1[i] = S.charAt(i)  - '0';
        }
        res[0] = S1[0];
        for (int i = 1;i < K; i++) {
            res[i] = S1[i] ^ S1[i-1];
        }
        for (int i = K;i < N; i++) {
            res[i] = S1[i] ^ res[i-K] ^ S1[i-1];
        }
        for (int i = 0;i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}

package algorithms.networkMeasurement.byteDance;

import java.util.Scanner;

/**
 * Created by thpffcj on 2020/2/1.
 *
 * 有三只球队，每只球队编号分别为球队1，球队2，球队3，这三只球队一共需要进行 n 场比赛。现在已经踢完了k场比赛，每场比赛不能打平，踢赢
 * 一场比赛得一分，输了不得分不减分。已知球队1和球队2的比分相差d1分，球队2和球队3的比分相差d2分，每场比赛可以任意选择两只队伍进行。
 * 求如果打完最后的 (n-k) 场比赛，有没有可能三只球队的分数打平。
 *
 * 输入描述:
 * 第一行包含一个数字 t (1 <= t <= 10)
 * 接下来的t行每行包括四个数字 n, k, d1, d2(1 <= n <= 10^12; 0 <= k <= n, 0 <= d1, d2 <= k)
 *
 * 输出描述:
 * 每行的比分数据，最终三只球队若能够打平，则输出“yes”，否则输出“no”
 *
 * 输入例子1:
 * 2
 * 3 3 0 0
 * 3 3 3 3
 *
 * 输出例子1:
 * yes
 * no
 *
 * 例子说明1:
 * case1: 球队1和球队2 差0分，球队2 和球队3也差0分，所以可能的赛得分是三只球队各得1分
 * case2: 球队1和球队2差3分，球队2和球队3差3分，所以可能的得分是 球队1得0分，球队2得3分, 球队3 得0分，比赛已经全部结束因此最终不能打平。
 */
public class BigData201810 {

    // https://blog.csdn.net/ansizhong9191/article/details/88365119
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            long n = sc.nextLong();
            long k = sc.nextLong();
            long d1 = sc.nextLong();
            long d2 = sc.nextLong();

            // 1. a > b > c
            long m = k + d2 + 2 * d1;
            long need;
            if (m >= 0 && m % 3 == 0) {
                need = (n - k) - (2 * d1 + d2);
                if (need >= 0 && need % 3 == 0) {
                    System.out.println("yes");
                    continue;
                }
            }
            // 2. a < b < c
            m = k - d2 - 2 * d1;
            if (m >= 0 && m % 3 == 0) {
                need = (n - k) - (d1 + 2 * d2);
                if (need >= 0 && need % 3 == 0) {
                    System.out.println("yes");
                    continue;
                }
            }
            // 3. a < b, b > c
            m = k + d2 - 2 * d1;
            if (m >= 0 && m % 3 == 0) {
                need = (n - k) - (d1 + d2);
                if (need >= 0 && need % 3 == 0) {
                    System.out.println("yes");
                    continue;
                }
            }
            // 4. a > b, b < c
            m = k - d2 + 2 * d1;
            if (m >= 0 && m % 3 == 0) {
                if (d2 > d1) {
                    need = (n - k) - (2 * d2 - d1);
                } else {
                    need = (n - k) - (2 * d1 - d2);
                }

                if (need >= 0 && need % 3 == 0) {
                    System.out.println("yes");
                    continue;
                }
            }
            System.out.println("no");
        }
    }
}

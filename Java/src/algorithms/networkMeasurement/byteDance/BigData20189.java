package algorithms.networkMeasurement.byteDance;

import java.util.Scanner;

/**
 * Created by thpffcj on 2020/1/29.
 *
 * 有n个房间，现在i号房间里的人需要被重新分配，分配的规则是这样的：先让i号房间里的人全都出来，接下来按照 i+1, i+2, i+3, ... 的顺序依
 * 此往这些房间里放一个人，n号房间的的下一个房间是1号房间，直到所有的人都被重新分配。
 * 现在告诉你分配完后每个房间的人数以及最后一个人被分配的房间号x，你需要求出分配前每个房间的人数。数据保证一定有解，若有多解输出任意一个解。
 *
 * 输入描述:
 * 第一行两个整数n, x (2<=n<=10^5, 1<=x<=n)，代表房间房间数量以及最后一个人被分配的房间号；
 * 第二行n个整数 a_i(0<=a_i<=10^9) ，代表每个房间分配后的人数。
 *
 * 输出描述:
 * 输出n个整数，代表每个房间分配前的人数。
 *
 * 输入例子1:
 * 3 1
 * 6 5 1
 *
 * 输出例子1:
 * 4 4 4
 */
public class BigData20189 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            long[] room = new long[n];
            for (int i = 0; i < n; i++) {
                room[i] = sc.nextLong();
            }

            x--;
            int last = x;
            long min = room[x];
            // 寻找最后分配房间，如果最小的不唯一，则最后一人房间为最后分配
            for (int i = x + n; i > x; i--) {
                if (room[i % n] < min) {
                    min = room[i % n];
                    last = i % n;
                }
            }

            if (last > x) {
                x += n;
            }
            // 处理多一轮循环
            for (int i = last + 1; i <= x; i++) {
                room[i % n]--;
            }

            long cycle = room[last];
            // 处理所有房间
            for (int i = 0; i < n; i++) {
                room[i] -= cycle;
            }
            // 恢复分配房间人数
            room[last] = cycle * n + x - last;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < room.length; i++) {
                sb.append(room[i]).append(" ");
            }
            System.out.println(sb.subSequence(0, sb.length() - 1));
        }
    }
}

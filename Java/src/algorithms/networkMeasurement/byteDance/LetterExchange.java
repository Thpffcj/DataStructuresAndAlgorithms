package algorithms.networkMeasurement.byteDance;

/**
 * Created by thpffcj on 2019/9/29.
 */

import java.util.Scanner;

/**
 * 字符串S由小写字母构成，长度为n。定义一种操作，每次都可以挑选字符串中任意的两个相邻字母进行交换。询问在至多交换m次之后，字符串中最
 * 多有多少个连续的位置上的字母相同？
 *
 * 输入描述:
 * 第一行为一个字符串S与一个非负整数m。(1 <= |S| <= 1000, 1 <= m <= 1000000)
 *
 * 输出描述:
 * 一个非负整数，表示操作之后，连续最长的相同字母数量。
 *
 * 输入例子1:
 * abcbaa 2
 *
 * 输出例子1:
 * 2
 *
 * 例子说明1:
 * 使2个字母a连续出现，至少需要3次操作。即把第1个位置上的a移动到第4个位置。
 * 所以在至多操作2次的情况下，最多只能使2个b或2个a连续出现。
 */
public class LetterExchange {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(" ");
            String s = line[0];
            int swap = Integer.parseInt(line[1]);

            
        }
    }
}

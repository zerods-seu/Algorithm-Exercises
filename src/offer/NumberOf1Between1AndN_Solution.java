package offer;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别
 * 数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问
 * 题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负
 * 整数区间中1出现的次数
 * @author zerods
 * @version 1.0 28/08/2017
 */
public class NumberOf1Between1AndN_Solution {

    public static int numberOf1Between1AndN_Solution(int n) {
        // 1的个数
        int count = 0;
        // 当前位,1->10->100->...
        int i = 1;
        int current = 0, after = 0, before = 0;
        while ((n / i) != 0) {
            // 当前位数字
            current = (n / i) % 10;
            // 高位数字
            before = n / (i * 10);
            // 低位数字
            after = n - (n / i) * i;
            if (current == 0) count += before*i;                            //如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
            else if (current == 1) count += before * i + after + 1;         //如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
            else { count += (before + 1) * i; }                             //如果大于1,出现1的次数由高位决定, （高位数字+1）* 当前位数
            i = i * 10;  //前移一位
        }
        return count;
    }

   /* private static int NumOf1(int n) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
            if (sb.indexOf("1") != -1) {
                sum++;
            }
            sb.delete(0, sb.length());
        }
        return sum;
    }*/

    public static void main(String[] args) {
        NumberOf1Between1AndN_Solution n1b1an = new NumberOf1Between1AndN_Solution();
        System.out.println(numberOf1Between1AndN_Solution(15));
    }
}

/**
 * 一副扑克牌,里面有2个大王,2个小王(一副牌原本是54张)...
 * 随机从中抽出了5张牌,看能不能抽到顺子.决定大\小王可以看成任何数字,
 * 并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4).
 * 为了方便起见,你可以认为大小王是0。
 *
 * @author zerods
 * @version 1.0 11/09/2017
 */
public class IsContunious {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        int[] numCount = new int[14];
        int min = 14, max = -1;
        for (int i = 0; i < numbers.length; i++) {
            int curNum = numbers[i];
            numCount[curNum]++;
            if (curNum == 0) continue;
            if (numCount[curNum] > 1) {
                return false;
            }
            max = curNum > max ? curNum : max;
            min = curNum < min ? curNum : min;
        }
        return max - min < 5;
    }
}

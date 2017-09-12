package offer;

/**
 * 题目：孩子们的游戏（圆圈中最后剩下的数）
 * 描述：
 * 随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌
 * 然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,
 * 继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
 * (注：小朋友的编号是从0到n-1)
 *
 * @author zerods
 * @version 1.0 11/09/2017
 */
public class LastRemaining {
    public int LastRemaining_Solution(int n, int m) {
        boolean[] deadFlags = new boolean[n];
        int liveSize = n;

        int index = -1;
        // 从0号同学开始报数
        int curIndex = 0;

        while (liveSize > 1) {                                      // 游戏存活的人数大于1
            int count = 0;                                          // 当前要报的数字，初始化为0
            while (count != m - 1) {                                // 当当前要报的数组不为m - 1，循环报数
                while (deadFlags[curIndex]) {                       // 找到下一个存活的同学
                    /*curIndex = (++curIndex == n ? 0 : curIndex);*/
                    curIndex++;
                    if (curIndex == n) {
                        curIndex = 0;
                    }
                }
                count++;                                            // 存活的同学报数
                curIndex++;                                         // 下一个同学报数
                if (curIndex == n) {
                    curIndex = 0;
                }
                while (deadFlags[curIndex]) {                       // 找到下一个存活的同学
                    /*curIndex = (++curIndex == n ? 0 : curIndex);*/
                    curIndex++;
                    if (curIndex == n) {
                        curIndex = 0;
                    }
                }
            }

            deadFlags[curIndex] = true;
            liveSize--;
        }

        for (int i = 0; i < n; i++) {
            if (!deadFlags[i]) {
                index = i;
                break;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        System.out.println(new LastRemaining().LastRemaining_Solution(5, 3));
    }
}

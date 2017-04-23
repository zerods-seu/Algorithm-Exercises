package offer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含
 * 有该整数。
 * Created by zerods on 2017/3/14.
 */
public class SearchInTwoDimensionalArray {
    // 以右上角元素作为突破口，如果目标元素大于这个元素，则丢掉此元素所在
    // row， 如果目标元素小于这个元素，则丢掉col
    public static boolean Find(int target, int[][] array) {
        int row = 0;
        int col = array[0].length - 1;

        while (row < array.length && col >= 0) {
            int rightTop = array[row][col];
            if      (target < rightTop) col--;
            else if (target > rightTop) row++;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3 ,4}, {6, 7, 8, 9},
                         {11, 12, 13, 14}, {16, 17, 18, 19}};
        for (int i = 0; i < 20; i++) {
            boolean flag = Find(i, array);
            if (flag)  {
                System.out.println(i + " is in the array");
            } else {
                System.out.println(i + " is not in the array");

            }
        }
    }
}

package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 * 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

 * @author zerods
 * @version 1.0 2017/3/31
 */
public class PrintMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
//        int[][] matrix = {{1, 2, 3, 4, 5}};
//        int[][] matrix = {{1}};
//        int[][] matrix = {{1}, {2}, {3}, {4}, {5}};
//        int[][] matrix = {{1,2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
        ArrayList<Integer> list = printMatrix(matrix);
        for (Integer i : list)
            System.out.println(i);
    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        printMatrix(list, matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);
        return list;
    }

    private static void printMatrix(
            ArrayList<Integer> list, int [][] matrix, int rowLo, int rowHi, int colLo, int colHi) {
        if (rowLo > rowHi || colLo > colHi) {
            return;
        } else if (rowLo == rowHi && colHi == colLo) {
            list.add(matrix[rowHi][colHi]);
            return;
        } else if (rowLo == rowHi && colHi != colLo) {
            for (int i = colLo; i <= colHi; i++)
                list.add(matrix[rowLo][i]);
            return;
        } else if (colLo == colHi && rowHi != rowLo) {
            for (int j = rowLo; j <= rowHi; j++)
                list.add(matrix[j][colLo]);
            return;
        } else {
            for (int i = colLo; i <= colHi; i++)
                list.add(matrix[rowLo][i]);
            for (int j = rowLo + 1; j <= rowHi; j++)
                list.add(matrix[j][colHi]);
            for (int i = colHi - 1; i >= colLo; i--)
                list.add(matrix[rowHi][i]);
            for (int j = rowHi - 1; j > rowLo; j--)
                list.add(matrix[j][colLo]);
            printMatrix(list, matrix, rowLo + 1, rowHi - 1, colLo + 1, colHi - 1);
        }
    }
}

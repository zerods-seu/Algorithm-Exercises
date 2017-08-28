package offer;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * Procedure LCS_LENGTH(X,Y);
     begin
         m:=length[X];
         n:=length[Y];
         for i:=1 to m do
            c[i,0]:=0;
         for j:=1 to n do
            c[0,j]:=0;
         for i:=1 to m do
            for j:=1 to n do
                if x[i]=y[j] then
                    begin
                        c[i,j]:=c[i-1,j-1]+1;
                        b[i,j]:="↖";
                    end
                else if c[i-1,j]≥c[i,j-1] then
                    begin
                        c[i,j]:=c[i-1,j];
                        b[i,j]:="↑";
                    end
                else
                    begin
                        c[i,j]:=c[i,j-1];
                        b[i,j]:="←"
                    end;
        return(c,b);
    end;
 * 最长公共子序列问题，动态规划
 * @author zerods
 * @version 1.0 28/08/2017
 */

public class LCS {
    public static int[][] c;
    public static char[][] b;

    public static void LCS_LENGTH(final String x, final String y) {
        int m = x.length();
        int n = y.length();
        c = new int[m + 1][n + 1];
        b = new char[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)){
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = '↖';
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = '↑';
                }  else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = '←';
                }

            }
        }

        for (int[] a : c) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("==========================");
        for (char[] charA : b) {
            System.out.println(Arrays.toString(charA));
        }
    }

    /*
        Procedure LCS(b,X,i,j);
            begin
              if i=0 or j=0 then return;
              if b[i,j]="↖" then
                begin
                  LCS(b,X,i-1,j-1);
                  print(x[i]); {打印x[i]}
                end
              else if b[i,j]="↑" then LCS(b,X,i-1,j)
              else LCS(b,X,i,j-1);
            end;
     */
    public static void LCS(final String x, int i, int j) {
        if (i == 0 || j == 0) { return; }
        if (b[i][j] == '↖') {
            LCS(x,i-1,j-1);
            System.out.println(x.charAt(i - 1));
        }
        else if (b[i][j] == '↑') { LCS(x, i - 1, j); }
        else { LCS(x, i,j - 1); }
    }

    public static void main(String[] args) {
        String x = "BDCABA";
        String y = "ABCBDAB";
        LCS_LENGTH(x, y);
        LCS(x, x.length(), y.length());
    }

    public static void lcs_2(String[] args){
        //设置字符串长度
        int substringLength1 = 20;
        int substringLength2 = 20;  //具体大小可自行设置

        // 随机生成字符串
        String x = GetRandomStrings(substringLength1);
        String y = GetRandomStrings(substringLength2);

        Long startTime = System.nanoTime();
        // 构造二维数组记录子问题x[i]和y[i]的LCS的长度
        int[][] opt = new int[substringLength1 + 1][substringLength2 + 1];

        // 动态规划计算所有子问题
        for (int i = substringLength1 - 1; i >= 0; i--){
            for (int j = substringLength2 - 1; j >= 0; j--){
                if (x.charAt(i) == y.charAt(j))
                    opt[i][j] = opt[i + 1][j + 1] + 1;
                else
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
            }
        }

        System.out.println("substring1:"+x);
        System.out.println("substring2:"+y);
        System.out.print("LCS:");

        int i = 0, j = 0;
        while (i < substringLength1 && j < substringLength2){
            if (x.charAt(i) == y.charAt(j)){
                System.out.print(x.charAt(i));
                i++;
                j++;
            } else if (opt[i + 1][j] >= opt[i][j + 1])
                i++;
            else
                j++;
        }
        Long endTime = System.nanoTime();
        System.out.println(" Totle time is " + (endTime - startTime) + " ns");
    }

    //取得定长随机字符串
    private static String GetRandomStrings(int length){
        StringBuffer buffer = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
        StringBuffer sb = new StringBuffer();
        Random r = new Random();
        int range = buffer.length();
        for (int i = 0; i < length; i++){
            sb.append(buffer.charAt(r.nextInt(range)));
        }
        return sb.toString();
    }
}

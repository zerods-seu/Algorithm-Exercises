package offer;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”.
 * 例如，当字符串为We Are Happy.则经过替换之后的
 * 字符串为We%20Are%20Happy。
 * Created by zerods on 2017/3/14.
 */
public class StringReplace {
    public static String replaceSpace(StringBuffer str) {
        int len = str.length();
        int numOfSpace = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                numOfSpace++;
            }
        }
        str.setLength(len + 2 * numOfSpace);
        int indexOld = len - 1;
        int indexNew = str.length() - 1;

        while (indexOld >= 0) {
            if (str.charAt(indexOld) == ' ') {
                str.setCharAt(indexNew--, '0');
                str.setCharAt(indexNew--, '2');
                str.setCharAt(indexNew--, '%');
            } else {
                str.setCharAt(indexNew--, str.charAt(indexOld));
            }
            indexOld--;
        }

        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("Hello world!")));
        System.out.println(replaceSpace(new StringBuffer("Hell oworld!")));
        System.out.println(replaceSpace(new StringBuffer("Hel loworld!")));
        System.out.println(replaceSpace(new StringBuffer("He lloworld!")));
        System.out.println(replaceSpace(new StringBuffer(" He lloworld!")));
    }
}

package offer;

/**
 * @author zerods
 * @version 1.0 12/09/2017
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n < 1) return "";
        if (n == 1) {
            return "1";
        } else {
            String s = countAndSay(n - 1);
            StringBuilder sb = new StringBuilder();
            int i = 0;
            char curChar = s.charAt(i);
            int count = 0;
            while (i < s.length()) {
                char c = s.charAt(i);
                if (c == curChar) {
                    count++;
                    i++;
                } else {
                    sb.append(count);
                    sb.append(curChar);
                    curChar = c;
                    count = 1;
                    i++;
                }
            }
            sb.append(count);
            sb.append(curChar);

            return sb.toString();
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            System.out.println(new CountAndSay().countAndSay(i));
        }
//        System.out.println(new CountAndSay().countAndSay(3));
    }
}

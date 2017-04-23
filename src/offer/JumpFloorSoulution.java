package offer;

/**
 * @author zerods
 * @version 1.0 2017/3/22
 */
public class JumpFloorSoulution {
    public static int JumpFloorII(int target) {
        if (target <= 1) {
            return 1;
        } else {
            int sum = 0;
            while (--target >= 0) {
                sum += JumpFloorII(target);
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        System.out.print(JumpFloorII(1) + " ");
        System.out.print(JumpFloorII(2) + " ");
        System.out.print(JumpFloorII(3) + " ");
        System.out.print(JumpFloorII(4) + " ");
        System.out.print(JumpFloorII(5) + " ");
        System.out.print(JumpFloorII(6) + " ");
    }

}

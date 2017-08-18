package offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,
 * @author zerods
 * @version 1.0 18/08/2017
 */
public class GetLeastNumbers_Solution {
    public ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> ints = new ArrayList<>();
        if (input != null && input.length > 0 && k <= input.length) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int a : input) {
                pq.add(a);
            }
            System.out.println(pq);
            for (int i = 0; i < k; i++) {
                ints.add(pq.remove());
            }
        }

        return ints;
    }

    public static void main(String[] args) {
        System.out.println(new GetLeastNumbers_Solution().getLeastNumbers_Solution(new int[] {4,5,1,6,2,7,3,8}, 4));
    }
}

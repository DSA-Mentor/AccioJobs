import java.io.*;
import java.util.*;

class Solution {
    public void firstElementToOccurKTimes(int[] nums, int n, int k) {
        HashMap<Integer, Integer> fmap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            // if (fmap.containsKey(num) == true) {
            // int prevFreq = fmap.get(num);
            // fmap.put(num, prevFreq + 1);
            // } else {
            // fmap.put(num, 1);
            // }

            fmap.put(num, fmap.getOrDefault(num, 0) + 1);

            if (fmap.get(num) == k) {
                System.out.println(num);
                return;
            }
        }

        System.out.println(-1);
        return;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k;
        n = sc.nextInt();
        k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Solution Obj = new Solution();
        Obj.firstElementToOccurKTimes(nums, n, k);
        System.out.println();
    }
}
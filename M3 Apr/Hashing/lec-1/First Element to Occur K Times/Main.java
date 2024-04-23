import java.io.*;
import java.util.*;

class Solution {
    public void firstElementToOccurKTimes(int[] nums, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            // if (map.containsKey(num) == true) {
            // map.put(num, map.get(num) + 1);
            // } else {
            // map.put(num, 1);
            // }

            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) == k) {
                System.out.println(num);
                return;
            }
        }

        System.out.println(-1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k;
        n = sc.nextInt();
        k = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Solution Obj = new Solution();
        Obj.firstElementToOccurKTimes(nums, n, k);
        System.out.println();
    }
}
import java.io.*;
import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    public void firstElementToOccurKTimes(int[] nums, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int ele : nums) {
            int freq = map.getOrDefault(ele, 0);
            map.put(ele, freq + 1);

            if (map.get(ele) == k) {
                System.out.println(ele);
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
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Solution Obj = new Solution();
        Obj.firstElementToOccurKTimes(nums, n, k);
        System.out.println();
    }
}
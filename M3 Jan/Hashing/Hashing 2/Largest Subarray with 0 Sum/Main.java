import java.util.HashMap;
import java.io.*;
import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    public int maxLen(int arr[]) {
        // Write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int rSum = 0;
        map.put(0, -1);

        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            rSum += arr[i];

            if (map.containsKey(rSum) == true) {
                int len = i - map.get(rSum);
                maxLen = Math.max(maxLen, len);
            } else {
                map.put(rSum, i);
            }
        }

        return maxLen;
    }
}

class Main {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.maxLen(nums));
    }
}

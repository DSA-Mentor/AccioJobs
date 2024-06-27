import java.util.HashMap;
import java.io.*;
import java.util.*;

class Solution {
    public int maxLen(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int rsum = 0;
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int ele = arr[i];
            rsum += ele;

            if (map.containsKey(rsum) == true) {
                int len = i - map.get(rsum);
                maxLen = Math.max(maxLen, len);
            } else {
                map.put(rsum, i);
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

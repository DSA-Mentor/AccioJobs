import java.util.HashMap;
import java.io.*;
import java.util.*;

class Solution {
    public int maxLen(int arr[]) {
        // Write your code here
        int rSum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int len = 0;

        for (int i = 0; i < arr.length; i++) {
            rSum += arr[i];

            if (map.containsKey(rSum) == true) {
                len = Math.max(len, i - map.get(rSum));
            } else {
                map.put(rSum, i);
            }
        }

        return len;
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

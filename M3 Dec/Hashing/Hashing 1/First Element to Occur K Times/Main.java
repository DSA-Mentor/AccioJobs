import java.io.*;
import java.util.*;

class Solution {
    public void firstElementToOccurKTimes(int[] nums, int n, int k) {
        // Your code here
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int i : nums) {
            int prevFreq = freqMap.getOrDefault(i, 0);
            freqMap.put(i, prevFreq + 1);

            if (freqMap.get(i) == k) {
                System.out.print(i);
                return;
            }
        }

        System.out.print(-1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k;
        n = sc.nextInt();
        k = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Solution Obj = new Solution();
        Obj.firstElementToOccurKTimes(nums, n, k);  
        System.out.println();
    }
}
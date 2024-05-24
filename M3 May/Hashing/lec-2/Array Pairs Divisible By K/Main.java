import java.io.*;
import java.util.*;

class Solution {
    public boolean arrayPairs(int[] arr, int k) {
        // freq of rem
        HashMap<Integer, Integer> remFreq = new HashMap<>();

        for (int ele : arr) {
            int rem = ele % k;
            remFreq.put(rem, remFreq.getOrDefault(rem, 0) + 1);
        }

        for (int r : remFreq.keySet()) {
            if (r == 0) {
                if (remFreq.get(r) % 2 != 0) {
                    return false;
                }
            } else {
                int cr = k - r;
                if (remFreq.containsKey(cr) == false || (remFreq.get(cr) != remFreq.get(r))) {
                    return false;
                }
            }
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k;
        n = sc.nextInt();
        k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        if (Obj.arrayPairs(arr, k)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
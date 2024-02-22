import java.io.*;
import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    public boolean arrayPairs(int[] arr, int k) {
        HashMap<Integer, Integer> fmap = new HashMap<>();

        for (int num : arr) {
            int rem = num % k;
            fmap.put(rem, fmap.getOrDefault(rem, 0) + 1);
        }

        for (int r1 : fmap.keySet()) {
            if (r1 == 0) {
                if (fmap.get(r1) % 2 == 1) {
                    return false;
                }
            } else {
                int r2 = k - r1;
                if (fmap.containsKey(r2) == false || fmap.get(r1) != fmap.get(r2)) {
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
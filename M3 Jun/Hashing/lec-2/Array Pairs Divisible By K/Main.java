import java.io.*;
import java.util.*;

class Solution {
    public boolean arrayPairs(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int ele : arr) {
            int rem = ele % k;
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        for (int r1 : map.keySet()) {
            if (r1 == 0) {
                if (map.get(r1) % 2 != 0) {
                    return false;
                }
            } else {
                int r2 = k - r1;
                if (map.containsKey(r2) == false) {
                    return false;
                } else if (map.get(r2) != map.get(r1)) {
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
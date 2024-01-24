import java.io.*;
import java.util.*;

class Solution {
    public boolean arrayPairs(int[] arr, int k) {
        // create a freq map for rem
        HashMap<Integer, Integer> remFreq = new HashMap<>();
        for (int num : arr) {
            int rem = num % k;
            remFreq.put(rem, remFreq.getOrDefault(rem, 0) + 1);
        }

        for (int rem : remFreq.keySet()) {
            if (rem == 0) {
                if (remFreq.get(rem) % 2 == 0) {
                    continue;
                } else {
                    return false;
                }
            }

            // compRem + rem = k
            int comRem = k - rem;
            if (remFreq.containsKey(comRem) == false) {
                return false;
            } else if (remFreq.get(comRem) != remFreq.get(rem)) {
                return false;
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
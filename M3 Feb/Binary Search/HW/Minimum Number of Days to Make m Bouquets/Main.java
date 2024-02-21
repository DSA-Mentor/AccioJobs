import java.io.*;
import java.util.*;

class Solution {
    public boolean isPossible(int[] bloomDay, int m, int k, int daysToBloom) {
        int numberOfBq = 0;
        int numberOfFl = 0;
        for (int bloom : bloomDay) {
            if (bloom <= daysToBloom) {
                numberOfFl++;
            } else {
                numberOfFl = 0;
            }

            if (numberOfFl == k) {
                numberOfBq++;
                numberOfFl = 0;
            }
        }

        return numberOfBq >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }

        int lo = 1;
        int hi = (int) 1e9;

        int pans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (isPossible(bloomDay, m, k, mid) == true) {
                pans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return pans;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.minDays(arr, m, k));
        sc.close();
    }
}

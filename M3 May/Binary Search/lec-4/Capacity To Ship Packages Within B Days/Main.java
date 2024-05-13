import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static boolean isPossible(int[] A, int B, long maxCap) {
        int dayNumber = 1;
        long currW = 0;

        for (int w : A) {
            if (w + currW <= maxCap) {
                currW += w;
            } else {
                if (w > maxCap) {
                    return false;
                }

                dayNumber++;
                currW = w;
            }
        }

        return dayNumber > B ? false : true;
    }

    public static long solve(int[] A, int B) {
        long si = 1;
        long ei = (long) 1e12;

        // minimize
        long pans = -1;
        while (si <= ei) {
            long mid = (si + ei) / 2;
            if (isPossible(A, B, mid) == true) {
                pans = mid;
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }

        return pans;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        System.out.println(Solution.solve(A, B));
    }
}
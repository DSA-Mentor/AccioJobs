import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static boolean isPossible(int[] pkgs, int days, long maxCap) {
        int dayNum = 1;
        long wtOnShip = 0;
        for (int pkg : pkgs) {
            if (wtOnShip + pkg <= maxCap) {
                wtOnShip += pkg;
            } else {
                if (wtOnShip > maxCap) {
                    return false;
                } else {
                    dayNum++;
                    wtOnShip = pkg;
                }
            }
        }

        return dayNum > days ? false : true;
    }

    public static long solve(int[] A, int B) {
        // Write your code here
        long si = 0;
        long ei = Long.MAX_VALUE;

        long pans = -1;

        while (si <= ei) {
            long mid = si + (ei - si) / 2;

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
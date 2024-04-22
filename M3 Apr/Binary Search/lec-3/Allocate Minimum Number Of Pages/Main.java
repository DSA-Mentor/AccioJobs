import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    // TC: O(N)
    public boolean isPossible(int[] Books, int M, long maxCap) {
        int stud = 1;
        long currPages = 0;

        for (int pages : Books) {
            if (currPages + pages <= maxCap) {
                currPages += pages;
            } else {
                stud++;
                currPages = pages;
            }
        }

        if (stud > M) {
            return false;
        } else {
            return true;
        }
    }

    // TC: O(NlogN)
    public long MinimumPages(int[] A, int B) {
        if (A.length < B) {
            return -1;
        }

        long lo = 0;
        long hi = 0;

        for (int Pages : A) {
            lo = Math.max(Pages, lo);
            hi += Pages;
        }

        long pans = -1;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;

            if (isPossible(A, B, mid) == true) {
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.MinimumPages(A, B));
    }
}
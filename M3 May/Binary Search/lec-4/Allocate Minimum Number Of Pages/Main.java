import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean isPossible(int[] books, int M, long maxPages) {
        int stud = 1;
        long currPages = 0;

        for (int book : books) {
            if (book + currPages <= maxPages) {
                currPages += book;
            } else {
                stud++;
                currPages = book;
            }
        }

        return stud > M ? false : true;
    }

    // TC: O(N*logN), SC: O(1)
    public long MinimumPages(int[] A, int B) {
        if (B > A.length) {
            return -1;
        }

        // define range [max in array, sum of array]
        long si = 0;
        long ei = 0;
        for (int book : A) {
            si = Math.max(si, book);
            ei += book;
        }

        // define pans
        long pans = -1;
        while (si <= ei) {
            long mid = (si + ei) / 2;

            if (isPossible(A, B, mid) == true) {
                // move towards left
                pans = mid;
                ei = mid - 1;
            } else {
                // move towards right
                si = mid + 1;
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
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();

        Solution Obj = new Solution();
        System.out.println(Obj.MinimumPages(A, B));
    }
}
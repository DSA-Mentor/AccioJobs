import java.util.*;
import java.lang.*;
import java.io.*;

// class Solution {
//     public boolean isPossible(int[] Books, int M, long maxPages) {
//         int studentNumber = 1;
//         int numberOfPages = 0;

//         for (int pages: Books) {
//             if (numberOfPages + pages <= maxPages) {
//                 numberOfPages += pages;
//             } else {
//                 studentNumber++;
//                 numberOfPages = pages;
//             }
//         }

//         return studentNumber > M ? false : true;
//     }

//     // TC: O(NlogN), SC: O(1)
//     public long MinimumPages(int[] A, int B) {
//         if (A.length < B) {
//             return -1;
//         }

//         long si = 0;
//         long ei = 0;
//         for (int pages : A) {
//             si = Math.max(si, pages);
//             ei += pages;
//         }

//         long pans = -1;
//         while (si <= ei) {
//             long mid = (si + ei) / 2;

//             if (isPossible(A, B, mid) == true) {
//                 pans = mid;
//                 // try minimizing
//                 ei = mid - 1;
//             } else {
//                 si = mid + 1;
//             }
//         }

//         return pans;
//     }
// }

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean isPossible(int[] Books, int M, long maxPages) {
        int studentNumber = 1;
        int numberOfPages = 0;

        for (int pages : Books) {
            if (numberOfPages + pages <= maxPages) {
                numberOfPages += pages;
            } else {
                studentNumber++;
                if (pages > maxPages) {
                    return false;
                }
                numberOfPages = pages;
            }
        }

        return studentNumber > M ? false : true;
    }

    // TC: O(NlogN), SC: O(1)
    public long MinimumPages(int[] A, int B) {
        if (A.length < B) {
            return -1;
        }

        long si = 0;
        long ei = (long) 1e18;

        long pans = -1;
        while (si <= ei) {
            long mid = (si + ei) / 2;

            if (isPossible(A, B, mid) == true) {
                pans = mid;
                // try minimizing
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

        int N = sc.nextInt();
        int B = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();

        Solution Obj = new Solution();
        System.out.println(Obj.MinimumPages(A, B));
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
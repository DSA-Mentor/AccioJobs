import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int B = sc.nextInt();

        Solution ob = new Solution();
        System.out.println(ob.search(A, B));
    }
}

class Solution {
    public int search(final int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[lo] <= arr[mid]) {
                // left is sorted
                // Range of value in left [arr[lo], arr[mid]]
                if (arr[lo] <= target && target <= arr[mid]) {
                    // might be in left side
                    hi = mid - 1;
                } else {
                    // eliminate the sorted range
                    lo = mid + 1;
                }
            } else {
                // left is unsorted
                // i.e. right is sorted
                // range of value in right [arr[mid], arr[hi]]
                if (arr[mid] <= target && target <= arr[hi]) {
                    // might be in right side
                    lo = mid + 1;
                } else {
                    // eliminate the sorted region
                    hi = mid - 1;
                }
            }
        }

        // unable to find
        return -1;
    }
}
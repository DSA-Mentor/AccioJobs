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
        // Write code here
        int n = arr.length;

        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[lo] <= arr[mid]) {
                // left side is sorted

                // do you lie in the range of left side [arr[lo], arr[mid]]
                if (target >= arr[lo] && target <= arr[mid]) {
                    // move left
                    hi = mid - 1;
                } else {
                    // you are not in left range, so try finding in right side
                    // move right
                    lo = mid + 1;
                }
            } else {
                // right side is sorted

                // do you lie in the range of right side [arr[mid], arr[hi]]
                if (target >= arr[mid] && target <= arr[hi]) {
                    // move right
                    lo = mid + 1;
                } else {
                    // you are not in right range, so try finding in left side
                    // move left
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }
}
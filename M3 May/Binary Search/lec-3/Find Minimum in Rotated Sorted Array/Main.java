
// Java program to find minimum element in a sorted and
// rotated array
import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {
    static int findMin(int arr[], int si, int ei) {
        int pmin = Integer.MAX_VALUE;
        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (arr[si] <= arr[mid]) {
                // left side sorted
                pmin = Math.min(pmin, arr[si]);
                si = mid + 1;
            } else {
                // right side sorted
                pmin = Math.min(pmin, arr[mid]);
                ei = mid - 1;
            }
        }

        return pmin;
    }
}

class Main {
    // Driver Program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Solution.findMin(arr, 0, n - 1));
    }
}
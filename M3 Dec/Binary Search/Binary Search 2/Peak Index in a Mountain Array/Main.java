import java.io.*;
import java.util.*;

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        // Write your code here
        int n = arr.length;

        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (mid + 1 >= n) {
                // I don't have a right side
                if (arr[mid - 1] < arr[mid]) {
                    return mid;
                } else {
                    hi = mid - 1;
                }
            } else if (mid - 1 < 0) {
                if (arr[mid + 1] < arr[mid]) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            } else {
                // Am I the peak
                if (arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
                    return mid;
                } else if (arr[mid - 1] <= arr[mid]) {
                    // left side is increasing
                    lo = mid + 1;
                } else {
                    // right side is decreasing
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for (int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.peakIndexInMountainArray(arr1);
        System.out.print(result + " ");
        System.out.println('\n');
    }
}
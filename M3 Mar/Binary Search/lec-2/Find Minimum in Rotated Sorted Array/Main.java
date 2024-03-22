
// Java program to find minimum element in a sorted and
// rotated array
import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {
    // static int findMin(int arr[], int si, int ei) {
    // int minValue = Integer.MAX_VALUE;

    // while (si <= ei) {
    // int mid = (si + ei) / 2;

    // // is left side sorted
    // if (arr[si] <= arr[mid]) {
    // minValue = Math.min(minValue, arr[si]);
    // // move towards unsorted region
    // si = mid + 1;
    // }
    // // rigth side is sorted
    // else {
    // minValue = Math.min(minValue, arr[mid]);
    // // move towards unsorted region
    // ei = mid - 1;
    // }
    // }

    // return minValue;
    // }

    static int findMin(int arr[], int si, int ei) {
        // if array not rotated
        if (arr[si] <= arr[ei]) {
            return arr[si];
        }

        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (arr[mid] < arr[mid - 1]) {
                // mid is pivot
                return arr[mid];
            } else if (arr[mid + 1] < arr[mid]) {
                // return mid + 1 is pivot
                return arr[mid + 1];
            } else if (arr[si] <= arr[mid]) {
                // left side is sorted
                // move towards right
                si = mid + 1;
            } else {
                // right part is sorted
                // move towards left
                ei = mid - 1;
            }
        }

        return -1;
    }
}

class Main {

    // Driver Program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(Solution.findMin(arr, 0, n - 1));
    }
}
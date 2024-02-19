
// Java program to find minimum element in a sorted and
// rotated array
import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {
    // static int findMin(int arr[], int low, int high) {
    // if (arr[low] <= arr[high]) {
    // // array is sorted
    // return arr[low];
    // }

    // while (low <= high) {
    // int mid = (low + high) / 2;

    // if (arr[mid] < arr[mid - 1]) {
    // return arr[mid];
    // } else if (arr[mid + 1] < arr[mid]) {
    // return arr[mid + 1];
    // } else if (arr[low] <= arr[mid]) {
    // // left is sorted move right
    // low = mid + 1;
    // } else {
    // // left is unsorted so move there
    // high = mid - 1;
    // }
    // }

    // return -1;
    // }

    static int findMin(int arr[], int low, int high) {
        int pans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[low] <= arr[mid]) {
                pans = Math.min(arr[low], pans);
                low = mid + 1;
            } else {
                pans = Math.min(arr[mid], pans);
                high = mid - 1;
            }
        }

        return pans;
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
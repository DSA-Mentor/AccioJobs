// Java program to find minimum element in a sorted and
// rotated array
import java.io.*;
import java.lang.*;
import java.util.*;
class Solution
{
    // TC: O(log N), SC: O(1)
    // static int findMin(int arr[], int lo, int hi)
    // {
    //     // if sorted array
    //     if (arr[lo] < arr[hi]) {
    //         return arr[lo]; 
    //     }
        
    //     while (lo <= hi) 
    //     {
    //         int mid = (lo + hi) / 2;

    //         // check is mid pivot or mid + 1 is pivot
    //         if (arr[mid] < arr[mid - 1]) {
    //             return arr[mid];
    //         } else if (arr[mid] > arr[mid + 1]) {
    //             return arr[mid + 1];
    //         } else if (arr[lo] <= arr[mid]) {
    //             // left side is sorted, move right
    //             lo = mid + 1;
    //         } else {
    //             // right side is sorted, move left
    //             hi = mid - 1;
    //         }
    //     }

    //     return -1;
    // }

    // TC: O(log N), SC: O(1)
    static int findMin(int arr[], int lo, int hi)
    {
        int pans = Integer.MAX_VALUE;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[lo] <= arr[mid]) {
                // left side is sorted
                pans = Math.min(pans, arr[lo]);

                lo = mid + 1;
            } else {
                // right side is sorted
                pans = Math.min(pans, arr[mid]);

                hi = mid - 1;
            }
        }

        return pans;
    }
}

class Main {
    // Driver Program
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(Solution.findMin(arr, 0, n - 1));
    }
}
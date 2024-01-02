// Java program to find minimum element in a sorted and
// rotated array
import java.io.*;
import java.lang.*;
import java.util.*;
class Solution
{
    static int findMin(int arr[], int lo, int hi)
    {
        //Write your code here
        int pans = Integer.MAX_VALUE;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[lo] <= arr[mid]) {
                // left side is sorted
                pans = Math.min(arr[lo], pans);

                lo = mid + 1;
            } else {
                pans = Math.min(arr[mid], pans);

                hi = mid - 1;
            }
        }

        return pans;
    }
}
class Main {
    
 
    // Driver Program
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++)
        arr[i] = sc.nextInt();
        System.out.println(Solution.findMin(arr, 0, n - 1));
    }
}
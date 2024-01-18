import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    
        int N = sc.nextInt();
    	
        int[] A = new int[N];
    	for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        
        int B = sc.nextInt();
        
        Solution ob = new Solution();
        System.out.println(ob.search(A,B));
	}
}

class Solution {
    // TC: O(log N), SC: O(1)
    public int search(final int[] a, int target) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (a[mid] == target) {
                return mid;
            } else if (a[lo] <= a[mid]) {
                // left side is sorted
                // check are you in sorted range
                if (a[lo] <= target && a[mid] >= target) {
                    // move towards sorted range
                    hi = mid - 1;
                } else {
                    // not in range of sorted range
                    lo = mid + 1;
                }
            } else {
                // right side is sorted
                // check are you in sorted range
                if (a[mid] <= target && a[hi] >= target) {
                    // move towards sorted range
                    lo = mid + 1;
                } else {
                    // not in range of sorted range
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }
}
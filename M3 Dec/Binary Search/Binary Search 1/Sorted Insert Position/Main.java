import java.io.*;
import java.util.*;

public class Main {
    // TC: O(log N), SC: O(1)
    public static int searchInsert(int[] arr, int key) {
        // Write code here
        int pans = arr.length;

        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                pans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return pans;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        System.out.println(searchInsert(A, B));
    }
}
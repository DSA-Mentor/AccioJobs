import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    // TC : O(log X), SC: O(1)
    public static void sqrt(int A) {
        long lo = 1;
        long hi = A;

        long pans = -1;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;

            if (mid * mid == A) {
                pans = mid;
                break;
            } else if (mid * mid > A) {
                hi = mid - 1;
            } else {
                pans = mid;
                lo = mid + 1;
            }
        }

        System.out.println(pans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        sqrt(A);
    }
}
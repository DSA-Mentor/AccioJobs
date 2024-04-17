import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void sqrt(int A) {
        long lo = 1;
        long hi = A;

        long pans = -1;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;

            if (mid * mid == A) {
                System.out.println(mid);
                return;
            } else if (mid * mid < A) {
                pans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
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
import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int ans = Solution.findEquilibriumIndex(a);
        System.out.println(ans);
    }
}

class Solution {
    static int findEquilibriumIndex(int[] a) {
        int totalSum = 0;
        for (int num : a) {
            totalSum += num;
        }

        int lsum = 0;
        for (int i = 0; i < a.length; i++) {
            int rsum = totalSum - lsum - a[i];

            if (rsum == lsum) {
                return i;
            }

            lsum += a[i];
        }

        return -1;
    }

    // static int findEquilibriumIndex(int[] a) {
    //     int n = a.length;

    //     int[] lsum = new int[n];
    //     lsum[0] = 0;
    //     for (int i = 1; i < n; i++) {
    //         lsum[i] = lsum[i - 1] + a[i - 1];
    //     }

    //     int[] rsum = new int[n];
    //     rsum[n - 1] = 0;
    //     for (int i = n - 2; i >= 0; i--) {
    //         rsum[i] = rsum[i + 1] + a[i + 1];
    //     }

    //     for (int i = 0; i < n; i++) {
    //         if (lsum[i] == rsum[i]) {
    //             return i;
    //         }
    //     }

    //     return -1;
    // }
}
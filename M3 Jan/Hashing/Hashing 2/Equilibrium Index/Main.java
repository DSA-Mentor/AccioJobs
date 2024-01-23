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
    // static int findEquilibriumIndex(int[] a) {
    // // Write code here
    // int[] lsum = new int[a.length];
    // lsum[0] = 0;
    // for (int i = 1; i < a.length; i++) {
    // lsum[i] = lsum[i - 1] + a[i - 1];
    // }

    // int[] rsum = new int[a.length];
    // rsum[a.length - 1] = 0;
    // for (int i = a.length - 2; i >= 0; i--) {
    // rsum[i] = rsum[i + 1] + a[i + 1];
    // }

    // for (int i = 0; i < a.length; i++) {
    // if (lsum[i] == rsum[i]) {
    // return i;
    // }
    // }

    // return -1;
    // }

    // TC: O(N), SC: O(1)
    static int findEquilibriumIndex(int[] a) {
        // Write code here
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
}
import java.io.*;
import java.util.*;

class Solution {
    static int[] nextSmallerElementOnLeftIndexwise(int[] arr, int n) {
        // Stack: people looking for nseli
        Stack<Integer> st = new Stack<>();

        int[] nseli = new int[n];

        // right -> left
        for (int i = n - 1; i >= 0; i--) {
            int ele = arr[i];
            while (st.size() > 0 && ele < arr[st.peek()]) {
                int idx = st.pop();
                nseli[idx] = i;
            }

            st.push(i);
        }

        while (st.size() > 0) {
            int idx = st.pop();
            nseli[idx] = -1;
        }

        return nseli;
    }

    static int[] nextSmallerElementOnRightIndexwise(int[] arr, int n) {
        // Stack: people looking for nseli
        Stack<Integer> st = new Stack<>();

        int[] nseri = new int[n];

        // right -> left
        for (int i = 0; i < n; i++) {
            int ele = arr[i];
            while (st.size() > 0 && ele <= arr[st.peek()]) {
                int idx = st.pop();
                nseri[idx] = i;
            }

            st.push(i);
        }

        while (st.size() > 0) {
            int idx = st.pop();
            nseri[idx] = n;
        }

        return nseri;
    }

    // TC: O(N), SC: O(N)
    long mod = 1000000007;

    public long minSubarraySum(int n, int a[]) {
        // write code here
        int[] nseli = nextSmallerElementOnLeftIndexwise(a, n);
        int[] nseri = nextSmallerElementOnRightIndexwise(a, n);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            int l = i - nseli[i] - 1;
            int r = nseri[i] - i - 1;

            long totalSub = ((l * 1) + (1 * r) + (l * 1 * r) + 1) % mod;

            // sum += (totalSub * arr[i])
            sum = (sum % mod + (totalSub * a[i]) % mod) % mod;
        }

        return sum;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.minSubarraySum(n, a));
    }
}
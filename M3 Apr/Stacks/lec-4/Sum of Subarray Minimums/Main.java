import java.io.*;
import java.util.*;

class Solution {
    // calculate next smaller or equal element on left
    public int[] nextSmallerElementOnLeft(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();

        int[] nseli = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int ele = arr[i];
            while (st.size() > 0 && ele <= arr[st.peek()]) {
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

    public int[] nextSmallerElementOnRight(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();

        int[] nseri = new int[n];

        for (int i = 0; i < n; i++) {
            int ele = arr[i];
            while (st.size() > 0 && ele < arr[st.peek()]) {
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
        int[] lb = nextSmallerElementOnLeft(a, n);
        int[] rb = nextSmallerElementOnRight(a, n);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            int A = i - lb[i] - 1;
            int B = rb[i] - i - 1;

            long totalOfSubarray = (1 + (A * 1) + (1 * B) + (A * 1 * B)) % mod;

            sum = (sum + (totalOfSubarray * a[i]) % mod) % mod;
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
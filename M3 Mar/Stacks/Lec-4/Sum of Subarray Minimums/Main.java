import java.io.*;
import java.util.*;

class Solution {
    public static int[] nextSmallerElementOnRightIndexwise(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();

        int[] nseri = new int[n];

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

    public static int[] nextSmallerElementOnLeftIndexwise(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();

        int[] nseli = new int[n];

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

    long mod = 1000000007;

    public long minSubarraySum(int n, int a[]) {
        int[] nseri = nextSmallerElementOnRightIndexwise(a, n);
        int[] nseli = nextSmallerElementOnLeftIndexwise(a, n);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            int nsr = nseri[i] - i - 1;
            int nsl = i - nseli[i] - 1;

            long noOfSubArray = (1 + nsr + nsl + nsr * nsl) % mod;
            sum = (sum + (noOfSubArray * a[i]) % mod) % mod;
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
import java.io.*;
import java.util.*;

class Solution {
    public int[] nextSmallerElementOnLeft(int[] arr, int n) {
        // Stack: element looking for nseli
        Stack<Integer> st = new Stack<>();

        int[] nseli = new int[n];

        // right to left
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

    public int[] nextSmallerElementOnRight(int[] arr, int n) {
        // Stack: element looking for nseri
        Stack<Integer> st = new Stack<>();

        int[] nseri = new int[n];

        // left to right
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

    long mod = 1000000007;

    public long minSubarraySum(int n, int a[]) {
        int[] nseli = nextSmallerElementOnLeft(a, n);
        int[] nseri = nextSmallerElementOnRight(a, n);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            int nl = i - nseli[i] - 1;
            int nr = nseri[i] - i - 1;

            int totalSubarray = 1 + (nl * 1) + (1 * nr) + (nl * 1 * nr);
            sum = ((sum % mod) + ((totalSubarray * a[i]) % mod)) % mod;
        }

        return sum % mod;
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
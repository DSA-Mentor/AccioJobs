import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        long[] arr = new long[(int) n];
        for (int i = 0; i < n; i++)
            arr[i] = Long.parseLong(inputLine[i]);
        System.out.println(new Solution().maximumArea(arr, n));
    }
}

class Solution {
    // static int[] nextSmallerElementOnLeftIndexwise(long[] arr, int n) {
    // // Stack: people looking for nseli
    // Stack<Integer> st = new Stack<>();

    // int[] nseli = new int[n];

    // // right -> left
    // for (int i = n - 1; i >= 0; i--) {
    // long ele = arr[i];
    // while (st.size() > 0 && ele < arr[st.peek()]) {
    // int idx = st.pop();
    // nseli[idx] = i;
    // }

    // st.push(i);
    // }

    // while (st.size() > 0) {
    // int idx = st.pop();
    // nseli[idx] = -1;
    // }

    // return nseli;
    // }

    // static int[] nextSmallerElementOnRightIndexwise(long[] arr, int n) {
    // // Stack: people looking for nseli
    // Stack<Integer> st = new Stack<>();

    // int[] nseri = new int[n];

    // // right -> left
    // for (int i = 0; i < n; i++) {
    // long ele = arr[i];
    // while (st.size() > 0 && ele < arr[st.peek()]) {
    // int idx = st.pop();
    // nseri[idx] = i;
    // }

    // st.push(i);
    // }

    // while (st.size() > 0) {
    // int idx = st.pop();
    // nseri[idx] = n;
    // }

    // return nseri;
    // }

    // TC: o(3N) ~ O(N), SC: O(N)
    // public static long maximumArea(long hist[], long n){
    // int[] nseli = nextSmallerElementOnLeftIndexwise(hist, (int) n);
    // int[] nseri = nextSmallerElementOnRightIndexwise(hist, (int) n);

    // long maxA = 0;
    // for (int i = 0; i < (int) n; i++) {
    // long h = hist[i];
    // int w = nseri[i] - nseli[i] - 1;

    // long area = h * w;
    // maxA = Math.max(maxA, area);
    // }

    // return maxA;
    // }

    // TC: O(N), SC: O(N)
    public static long maximumArea(long hist[], long n) {
        // stack: people looking for nseli
        Stack<Integer> st = new Stack<>();

        long maxA = 0;

        // right to left
        for (int i = (int) n - 1; i >= 0; i--) {
            long ele = hist[i];

            while (st.size() > 0 && ele < hist[st.peek()]) {
                int lb = i;
                int idx = st.pop();
                int rb = (int) n;
                if (st.size() > 0) {
                    rb = st.peek();
                }

                int w = rb - lb - 1;
                long h = hist[idx];

                long area = h * w;
                maxA = Math.max(maxA, area);
            }

            st.push(i);
        }

        while (st.size() > 0) {
            int lb = -1;
            int idx = st.pop();
            int rb = (int) n;
            if (st.size() > 0) {
                rb = st.peek();
            }

            int w = rb - lb - 1;
            long h = hist[idx];

            long area = h * w;
            maxA = Math.max(maxA, area);
        }

        return maxA;
    }
}

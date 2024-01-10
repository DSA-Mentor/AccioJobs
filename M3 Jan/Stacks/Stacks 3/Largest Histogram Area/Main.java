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
        System.out.println(new Solution().maximumArea(arr, (int) n));
    }
}

class Solution {
    // // TC: O(N), SC: O(N)
    // public static int[] nextSmallerElementOnLeftIndexwise(long[] arr, int n) {
    // // Stack -> people looking for nsel
    // Stack<Integer> st = new Stack<>();

    // int[] nseli = new int[n];

    // // move -> right to left
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

    // public static int[] nextSmallerElementOnRightIndexwise(long[] arr, int n) {
    // // Stack -> people looking for nser
    // Stack<Integer> st = new Stack<>();

    // int[] nseri = new int[n];

    // // move -> left to right
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

    // // TC: o(3*N), SC: o(4*N)
    // public static long maximumArea(long hist[], int n){
    // //Your code here
    // int[] nseli = nextSmallerElementOnLeftIndexwise(hist, n);
    // int[] nseri = nextSmallerElementOnRightIndexwise(hist, n);

    // long maxArea = 0;
    // for (int i = 0; i < n; i++) {
    // long h = hist[i];
    // int w = (nseri[i] - nseli[i] - 1);
    // long area = h * w;
    // maxArea = Math.max(maxArea, area);
    // }

    // return maxArea;
    // }

    // TC: o(N), o(N)
    public static long maximumArea(long hist[], int n) {
        // stack -> people looking for nsel
        Stack<Integer> st = new Stack<>();

        long maxArea = 0;

        // move -> right to left
        for (int i = n - 1; i >= 0; i--) {
            long ele = hist[i];

            while (st.size() > 0 && ele < hist[st.peek()]) {
                int idx = st.pop();
                int LB = i;

                int RB = n;
                if (st.size() > 0) {
                    RB = st.peek();
                }

                int w = RB - LB - 1;
                long area = w * hist[idx];
                maxArea = Math.max(maxArea, area);
            }

            st.push(i);
        }

        while (st.size() > 0) {
            int idx = st.pop();
            int LB = -1;

            int RB = n;
            if (st.size() > 0) {
                RB = st.peek();
            }

            int w = RB - LB - 1;
            long area = w * hist[idx];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
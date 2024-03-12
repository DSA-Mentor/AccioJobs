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
    // public static int[] nextSmallerElementOnRightIndexwise(long[] arr, int n) {
    // Stack<Integer> st = new Stack<>();

    // int[] nseri = new int[n];

    // for (int i = 0; i < n; i++) {
    // long ele = arr[i];
    // while(st.size() > 0 && ele < arr[st.peek()]) {
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

    // public static int[] nextSmallerElementOnLeftIndexwise(long[] arr, int n) {
    // Stack<Integer> st = new Stack<>();

    // int[] nseli = new int[n];

    // for (int i = n - 1; i >= 0; i--) {
    // long ele = arr[i];
    // while(st.size() > 0 && ele < arr[st.peek()]) {
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

    // public static long maximumArea(long hist[], long n) {
    // int[] nseli = nextSmallerElementOnLeftIndexwise(hist, (int)n);
    // int[] nseri = nextSmallerElementOnRightIndexwise(hist, (int)n);

    // long maxArea = 0;
    // for (int i = 0; i < (int) n; i++) {
    // long h = hist[i];
    // int w = nseri[i] - nseli[i] - 1;
    // long area = h * w;
    // maxArea = Math.max(area, maxArea);
    // }

    // return maxArea;
    // }

    public static long maximumArea(long hist[], long n) {
        long maxArea = 0;

        // people looking for nsel
        Stack<Integer> st = new Stack<>();

        for (int i = (int) n - 1; i >= 0; i--) {
            long ele = hist[i];

            while (st.size() > 0 && ele < hist[st.peek()]) {
                int idx = st.pop();
                int LB = i;

                int RB = (int) n;
                if (st.size() > 0) {
                    RB = st.peek();
                }

                int w = RB - LB - 1;
                long h = hist[idx];

                long area = h * w;
                maxArea = Math.max(area, maxArea);
            }

            st.push(i);
        }

        while (st.size() > 0) {
            int idx = st.pop();
            int LB = -1;

            int RB = (int) n;
            if (st.size() > 0) {
                RB = st.peek();
            }

            int w = RB - LB - 1;
            long h = hist[idx];

            long area = h * w;
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
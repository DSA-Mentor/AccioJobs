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
    // // next smaller on left indexwise
    // public static int[] nextSmallerOnLeftIndexwise(long[] arr, int n) {
    // // Stack: elements looking for there next smaller elements on left
    // Stack<Integer> st = new Stack<>();

    // int[] nseli = new int[n];

    // // move: right -> left
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

    // // next smaller on right indexwise
    // public static int[] nextSmallerOnRightIndexwise(long[] arr, int n) {
    // // Stack: elements looking for there next smaller elements on right
    // Stack<Integer> st = new Stack<>();

    // int[] nseri = new int[n];

    // // move: left -> right
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

    // public static long maximumArea(long hist[], int n) {
    // int[] nseli = nextSmallerOnLeftIndexwise(hist, n);
    // int[] nseri = nextSmallerOnRightIndexwise(hist, n);

    // long area = 0;

    // for (int i = 0; i < n; i++) {
    // long h = hist[i];
    // int w = nseri[i] - nseli[i] - 1;

    // long currArea = h*w;
    // area = Math.max(area, currArea);
    // }

    // return area;
    // }

    public static long maximumArea(long hist[], int n) {
        // Stack: ele looking for nseli
        Stack<Integer> st = new Stack<>();

        long area = 0;

        // right -> left
        for (int i = n - 1; i >= 0; i--) {
            long ele = hist[i];

            while (st.size() > 0 && ele < hist[st.peek()]) {
                int idx = st.pop();

                int lb = i;

                int rb = n;
                if (st.size() != 0) {
                    rb = st.peek();
                }

                int w = rb - lb - 1;
                long h = hist[idx];
                long currArea = h * w;
                area = Math.max(area, currArea);
            }

            st.push(i);
        }

        while (st.size() > 0) {
            int idx = st.pop();
            int lb = -1;

            int rb = n;
            if (st.size() != 0) {
                rb = st.peek();
            }

            int w = rb - lb - 1;
            long h = hist[idx];
            long currArea = h * w;
            area = Math.max(area, currArea);
        }

        return area;
    }
}
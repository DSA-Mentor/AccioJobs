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
    public static int[] nextSmallerElementOnRight(long[] arr, int n) {
        Stack<Integer> st = new Stack<>();

        int[] nseri = new int[n];

        // move left to right
        for (int i = 0; i < n; i++) {
            long ele = arr[i];

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

    public static int[] nextSmallerElementOnLeft(long[] arr, int n) {
        Stack<Integer> st = new Stack<>();

        int[] nseli = new int[n];

        // move right to left
        for (int i = n - 1; i >= 0; i--) {
            long ele = arr[i];

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

    // TC: O(N), SC: O(N)
    public static long maximumArea(long hist[], long n) {
        int[] rb = nextSmallerElementOnRight(hist, (int) n);
        int[] lb = nextSmallerElementOnLeft(hist, (int) n);

        long maxArea = 0;
        for (int i = 0; i < (int) n; i++) {
            long height = hist[i];
            int width = rb[i] - lb[i] - 1;
            long area = height * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    // Approach 1
    // TC: O(N), SC: O(1)
    // public static long[] nextLargerElement(long[] arr, int n) {
    // // Stack: potential nger
    // Stack<Long> st = new Stack<>();

    // long[] nger = new long[n];

    // // move right to left
    // for (int i = n - 1; i >= 0; i--) {
    // long ele = arr[i];

    // while (st.size() > 0 && ele >= st.peek()) {
    // st.pop();
    // }

    // if (st.size() == 0) {
    // nger[i] = -1;
    // } else {
    // nger[i] = st.peek();
    // }

    // st.push(ele);
    // }

    // return nger;
    // }

    // TC: O(N), SC: O(N)
    public static long[] nextLargerElement(long[] arr, int n) {
        // Stack: elements looking for there nger
        Stack<Integer> st = new Stack<>();

        long[] nger = new long[n];

        // left -> right
        for (int i = 0; i < n; i++) {
            long ele = arr[i];

            while (st.size() > 0 && ele > arr[st.peek()]) {
                int idx = st.pop();
                nger[idx] = ele;
            }

            st.push(i);
        }

        while (st.size() > 0) {
            int idx = st.pop();
            nger[idx] = -1;
        }

        return nger;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = Long.parseLong(inputLine[i]);
        long[] res = new Solution().nextLargerElement(arr, n);
        for (int i = 0; i < n; i++)
            System.out.print(res[i] + " ");
        System.out.println();
    }
}
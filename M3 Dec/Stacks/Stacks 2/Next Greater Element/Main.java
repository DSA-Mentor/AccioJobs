import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    // Approach 1
    // public static long[] nextLargerElement(long[] arr, int n)
    // {
    // // possible next greater element on right
    // Stack<Long> st = new Stack();

    // long[] nger = new long[n];

    // // move right to left
    // for (int i = n - 1; i >= 0; i--) {
    // long ele = arr[i];

    // while (st.size() > 0 && ele >= st.peek()) {
    // st.pop();
    // }

    // if (st.size() > 0) {
    // nger[i] = st.peek();
    // } else {
    // nger[i] = -1;
    // }

    // st.push(ele);
    // }

    // return nger;
    // }

    // Approach 2
    public static long[] nextLargerElement(long[] arr, int n) {
        // Stack: index of people looking for there nger
        Stack<Integer> st = new Stack();

        long[] nger = new long[n];

        // move left to right
        for (int i = 0; i < n; i++) {
            long ele = arr[i];

            while (st.size() > 0 && ele > arr[st.peek()]) {
                int idx = st.peek();
                nger[idx] = ele;
                st.pop();
            }

            st.push(i);
        }

        while (st.size() > 0) {
            int idx = st.peek();
            nger[idx] = -1;
            st.pop();
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
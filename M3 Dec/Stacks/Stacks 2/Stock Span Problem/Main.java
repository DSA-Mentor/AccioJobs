import java.io.*;
import java.util.*;

class Pair {
    int val;
    int idx;

    Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
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
        Solution s = new Solution();
        int ans[] = s.stockSpan(a);
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

class Solution {
    static int[] nextGreaterElementOnLeftIndexwise(int[] a) {
        // Stack: people looking for there ngeli
        Stack<Integer> st = new Stack();

        int[] ngeli = new int[a.length];

        // move: right to left
        for (int i = a.length - 1; i >= 0; i--) {
            int ele = a[i];

            while (st.size() > 0 && ele > a[st.peek()]) {
                int idx = st.peek();
                ngeli[idx] = i;
                st.pop();
            }

            st.push(i);
        }

        while (st.size() > 0) {
            int idx = st.peek();
            ngeli[idx] = -1;
            st.pop();
        }

        return ngeli;
    }

    static int[] stockSpan(int[] a) {
        int[] ngeli = nextGreaterElementOnLeftIndexwise(a);

        int[] span = new int[a.length];

        // span[i] = i - ngeli[i]
        for (int i = 0; i < a.length; i++) {
            span[i] = i - ngeli[i];
        }

        return span;
    }
}
import java.io.*;
import java.util.*;

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
    static int[] nextGreaterElementOnLeft(int[] arr) {
        // Stack: ele looking for ngel
        Stack<Integer> st = new Stack<>();

        int[] ngeli = new int[arr.length];

        // move: right -> left
        for (int i = arr.length - 1; i >= 0; i--) {
            int ele = arr[i];
            while (st.size() > 0 && ele > arr[st.peek()]) {
                int idx = st.pop();
                ngeli[idx] = i;
            }

            st.push(i);
        }

        while (st.size() > 0) {
            int idx = st.pop();
            ngeli[idx] = -1;
        }

        return ngeli;
    }

    static int[] stockSpan(int[] a) {
        int[] ngeli = nextGreaterElementOnLeft(a);

        int[] span = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            span[i] = i - ngeli[i];
        }

        return span;
    }
}
import java.util.*;

class Solution {
    // static int[] nextGreaterElementOnRightIndexwise(int[] arr, int n) {
    // Stack<Integer> st = new Stack<>();

    // int[] ngeri = new int[n];

    // // move: left -> right
    // for (int i = 0; i < n; i++) {
    // int ele = arr[i];

    // while (st.size() > 0 && ele > arr[st.peek()]) {
    // int idx = st.pop();
    // ngeri[idx] = i;
    // }

    // st.push(i);
    // }

    // while (st.size() > 0) {
    // int idx = st.pop();
    // ngeri[idx] = n;
    // }

    // return ngeri;
    // }

    // // TC: O(N), SC: O(N)
    // static int[] SlidingWindowMaximum(int n, int k, int[] arr){
    // int[] ngeri = nextGreaterElementOnRightIndexwise(arr, n);
    // int[] ans = new int[n - k + 1];
    // int win_num = 0;

    // int tallest = 0;
    // for (int i = 0; i <= n - k; i++) {
    // if (i > tallest) {
    // tallest = i;
    // }

    // while (ngeri[tallest] <= i + k - 1) {
    // tallest = ngeri[tallest];
    // }

    // ans[win_num] = arr[tallest];
    // win_num++;
    // }

    // return ans;
    // }

    // TC: O(N), SC: O(N)
    static int[] SlidingWindowMaximum(int n, int k, int[] arr) {
        int win = 0;
        int[] ans = new int[n - k + 1];

        // deque -> as stack use addLast and removeLast
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (dq.size() > 0 && dq.getFirst() <= i - k) {
                dq.removeFirst();
            }

            int ele = arr[i];

            while (dq.size() > 0 && arr[dq.getLast()] < ele) {
                int idx = dq.removeLast();
            }

            dq.addLast(i);

            if (i >= k - 1) {
                ans[win] = arr[dq.getFirst()];
                win++;
            }
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        int[] ans = obj.SlidingWindowMaximum(n, k, nums);
        for (int i = 0; i < ans.length; ++i) {
            System.out.print(ans[i] + " ");
        }
    }
}

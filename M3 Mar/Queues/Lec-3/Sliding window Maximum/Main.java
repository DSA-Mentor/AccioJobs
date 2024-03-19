import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    static int[] SlidingWindowMaximum(int N, int K, int[] arr) {
        // stack in deque: addLast, removeLast
        Deque<Integer> dq = new ArrayDeque<>();

        int[] window = new int[N - K + 1];
        int win_num = 0;

        // move left to right
        for (int i = 0; i < N; i++) {
            int ele = arr[i];

            while (dq.size() > 0 && ele > arr[dq.getLast()]) {
                dq.removeLast();
            }

            dq.addLast(i);

            // remove ele from stack outside the current and also subsequent windows
            int si = i - K + 1;
            while (dq.size() > 0 && dq.getFirst() < si) {
                dq.removeFirst();
            }

            // now as it is a monotonic stack for curr window, hence bottom of the stack is
            // max value of the window
            if (i >= K - 1) {
                window[win_num] = arr[dq.getFirst()];
                win_num++;
            }
        }

        return window;
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

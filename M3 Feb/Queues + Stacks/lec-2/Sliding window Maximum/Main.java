import java.util.*;

class Solution {
    static int[] SlidingWindowMaximum(int N, int K, int[] arr) {
        // to mimic deque as a stack: will use addFirst and removeFirst
        Deque<Integer> dq = new ArrayDeque<>();

        int[] ans = new int[N - K + 1];
        int win_num = 0;

        // move -> left to right
        for (int i = 0; i < N; i++) {
            int ele = arr[i];

            while (dq.size() > 0 && ele > arr[dq.getFirst()]) {
                dq.removeFirst();
            }

            dq.addFirst(i);

            while (dq.getLast() <= i - K) {
                dq.removeLast();
            }

            if (i >= K - 1) {
                ans[win_num] = arr[dq.getLast()];
                win_num++;
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

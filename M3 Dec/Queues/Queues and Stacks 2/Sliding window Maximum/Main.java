import java.util.*;

class Solution {
    // TC: O(N), O(K)
    static int[] SlidingWindowMaximum(int n, int k, int[] arr) {
        // write code here

        // Deque -> act as a stack -> addLast(), removeLast()
        Deque<Integer> dq = new ArrayDeque<>();

        int[] ans = new int[n - k + 1];
        int win_num = 0;

        for (int i = 0; i < n; i++) {
            if (dq.size() > 0 && dq.getFirst() < i - k + 1) {
                dq.removeFirst();
            }

            int ele = arr[i];
            while (dq.size() > 0 && ele > arr[dq.getLast()]) {
                dq.removeLast();
            }

            dq.addLast(i);

            if (i >= k - 1) {
                ans[win_num] = arr[dq.getFirst()];
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

import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    static int[] SlidingWindowMaximum(int N, int K, int[] arr) {
        // addLast and removeLast to mimic as a stack
        Deque<Integer> dq = new ArrayDeque<>();

        ArrayList<Integer> max = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int ele = arr[i];

            while (dq.size() > 0 && arr[dq.getLast()] < ele) {
                dq.removeLast();
            }

            dq.addLast(i);

            // started ending a window now
            if (i >= K - 1) {
                int si = i - K + 1;

                if (dq.size() > 0 && dq.getFirst() < si) {
                    dq.removeFirst();
                }

                // bottomost of stack in maximum
                int maxVal = arr[dq.getFirst()];

                max.add(maxVal);
            }
        }

        int[] ans = max.stream().mapToInt(i -> i).toArray();
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

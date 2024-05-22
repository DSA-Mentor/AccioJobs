import java.util.*;

class Solution {
    static int[] SlidingWindowMaximum(int N, int K, int[] arr) {
        // Stack: addLast(), removeLast(), getLast()
        Deque<Integer> dq = new ArrayDeque<>();

        ArrayList<Integer> ans = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            int si = i - K + 1;

            if (si >= 0 && dq.getFirst() < si) {
                // remove
                dq.removeFirst();
            }

            int ele = arr[i];
            while (dq.size() > 0 && ele > arr[dq.getLast()]) {
                dq.removeLast();
            }

            dq.addLast(i);

            if (i >= K - 1) {
                ans.add(arr[dq.getFirst()]);
            }
        }

        int[] a = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            a[i] = ans.get(i);
        }

        return a;
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

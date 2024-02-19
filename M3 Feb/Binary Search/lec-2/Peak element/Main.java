import java.util.*;

class Solution {
    public int findPeak(int arr[], int n) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (mid + 1 == arr.length) {
                if (arr[mid - 1] < arr[mid]) {
                    return mid;
                } else {
                    hi = mid - 1;
                }
            } else if (mid - 1 == -1) {
                if (arr[mid + 1] < arr[mid]) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
                    // you are the peak
                    return mid;
                } else if (arr[mid - 1] <= arr[mid]) {
                    // left side inc
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t > 0) {
                int n = sc.nextInt();
                int[] A = new int[n];
                for (int i = 0; i < n; i++) {
                    A[i] = sc.nextInt();
                }
                Solution ob = new Solution();
                int ans = ob.findPeak(A, n);
                if (ans == 0) {
                    if (A[ans] > A[ans + 1]) {
                        System.out.println("true");
                    } else {
                        System.out.println("false");
                    }
                } else if (ans == n - 1) {
                    if (A[ans] > A[ans - 1]) {
                        System.out.println("true");
                    } else {
                        System.out.println("false");
                    }
                } else {
                    if (A[ans] > A[ans + 1] && A[ans] > A[ans - 1]) {
                        System.out.println("true");
                    } else {
                        System.out.println("false");
                    }
                }
                t--;
            }
        }
    }
}
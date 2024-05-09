import java.util.*;

public class Main {
    // TC: O(log N), SC: O(1)
    public static int findFirstPosition(int[] arr, int n, int key) {
        int si = 0;
        int ei = n - 1;

        int fo = -1;

        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (arr[mid] == key) {
                fo = mid;
                // give a new try on left side
                ei = mid - 1;
            } else if (arr[mid] > key) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }

        return fo;
    }

    public static int findLastPosition(int[] arr, int n, int key) {
        int si = 0;
        int ei = n - 1;

        int lo = -1;

        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (arr[mid] == key) {
                lo = mid;
                // give a new try on right side
                si = mid + 1;
            } else if (arr[mid] > key) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }

        return lo;
    }

    public static void findPosition(int a[], int n, int k) {
        // Write code here
        int fo = findFirstPosition(a, n, k);
        int lo = findLastPosition(a, n, k);

        System.out.println(fo + " " + lo);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int array[] = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        findPosition(array, n, k);
    }
}
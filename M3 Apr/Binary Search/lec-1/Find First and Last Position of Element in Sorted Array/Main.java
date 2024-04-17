import java.util.*;

public class Main {
    static int firstOcc(int[] arr, int n, int k) {
        int fo = -1;

        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] == k) {
                fo = mid;
                // let's try to find again on left
                hi = mid - 1;
            } else if (arr[mid] < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return fo;
    }

    static int lastOcc(int[] arr, int n, int k) {
        int lastO = -1;

        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] == k) {
                lastO = mid;
                // let's try to find again on right
                lo = mid + 1;
            } else if (arr[mid] < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lastO;
    }

    public static void findPosition(int a[], int n, int k) {
        int fo = firstOcc(a, n, k);
        int lo = lastOcc(a, n, k);

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
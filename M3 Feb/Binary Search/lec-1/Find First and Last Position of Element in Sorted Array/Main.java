import java.util.*;

public class Main {
    public static int firstPosition(int[] arr, int n, int key) {
        int lo = 0;
        int hi = n - 1;

        int fp = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] == key) {
                fp = mid;
                hi = mid - 1;
            } else if (arr[mid] > key) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return fp;
    }

    public static int lastPosition(int[] arr, int n, int key) {
        int lo = 0;
        int hi = n - 1;

        int lp = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] == key) {
                lp = mid;
                lo = mid + 1;
            } else if (arr[mid] > key) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lp;
    }

    public static void findPosition(int a[], int n, int k) {
        int lp = lastPosition(a, n, k);
        int fp = firstPosition(a, n, k);

        System.out.println(fp + " " + lp);
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
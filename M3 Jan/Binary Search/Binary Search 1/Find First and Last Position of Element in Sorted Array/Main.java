import java.util.*;

public class Main {
    public static findFirstOcc(int[] arr, int n, int key) {
        int lo = 0;
        int hi = n - 1;

        int fo = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == key) {
                fo = mid;
                hi = mid - 1;
            } else if (arr[mid] > key) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return fo;
    }

    public static void findPosition(int a[], int n, int k) {
        // Write code here
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
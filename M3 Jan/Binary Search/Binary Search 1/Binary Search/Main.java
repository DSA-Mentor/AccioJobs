import java.util.*;

public class Main {
    // TC: O(log N), SC: O(1)
    public static int findIndex(int key, int[] arr) {
        // define the range of search
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            // get mid point
            int mid = (lo + hi) / 2;

            // Case: arr[mid] == key
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, key;
        n = sc.nextInt();
        key = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(findIndex(key, arr));
        sc.close();
    }
}
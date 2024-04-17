import java.util.*;

public class Main {
    // TC: O(log N), SC: O(1)
    public static int findIndex(int key, int[] arr) {
        // define region of search
        int lo = 0, hi = arr.length - 1;

        // try find answer, till a defined region of search
        while (lo <= hi) {
            // calc: mid point
            int mid = (lo + hi) / 2;

            // check arr you equal to key
            if (arr[mid] == key) {
                // answer found
                return mid;
            } else if (arr[mid] < key) {
                // remove smaller ele
                lo = mid + 1;
            } else {
                // remove bigger ele
                hi = mid - 1;
            }
        }

        // unable to find the key
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
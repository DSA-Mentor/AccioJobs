import java.util.*;

public class Main {
    // TC: O(log N), SC: O(1)
    public static int findIndex(int key, int[] arr) {
        // define the range
        int si = 0, ei = arr.length - 1;

        // till you have a valid
        while (si <= ei) {
            // get the mid point
            int mid = (si + ei) / 2;

            if (arr[mid] == key) {
                // return mid, found the key
                return mid;
            } else if (arr[mid] > key) {
                // right ele would be more greater, hence of no use
                // move left
                ei = mid - 1;
            } else {
                // left ele would be more smaller, hence of no use
                // move right
                si = mid + 1;
            }
        }

        // not able to find key
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
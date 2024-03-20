import java.util.*;

public class Main {
    // TC: O(log N), SC: O(log N)
    public static int recBS(int[] arr, int si, int ei, int key) {
        if (ei < si) {
            return -1;
        }

        int mid = (si + ei) / 2;

        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] > key) {
            // move left
            return recBS(arr, si, mid - 1, key);
        } else {
            // move right
            return recBS(arr, mid + 1, ei, key);
        }
    }

    // TC: O(log N), SC: O(1)
    public static int findIndex(int key, int[] arr) {
        // Write code here
        int si = 0;
        int ei = arr.length - 1;

        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                // move left
                ei = mid - 1;
            } else {
                // move right
                si = mid + 1;
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
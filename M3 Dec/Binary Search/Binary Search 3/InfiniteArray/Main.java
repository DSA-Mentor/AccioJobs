import java.util.*;

public class Main {
    public static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        // Fill the array with random values
        for (int i = 0; i < size - 1; i++) {
            array[i] = random.nextInt(10000) + 1; // Random values between 1 and 10000
        }

        array[size - 1] = 1041;

        // Sort the array
        Arrays.sort(array);

        return array;
    }

    static void printArray(int[] arr) {
        for (int e : arr) {
            System.out.print(e + " ");
        }

        System.out.println();
    }

    public static int BinarySearch(int[] arr, int lo, int hi, int tar) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == tar) {
                return mid;
            } else if (arr[mid] < tar) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = generateSortedArray(1000);

        printArray(arr);

        int target = 1041;

        int lo = 0;
        int hi = 1;
        int steps = 0;

        while (lo < arr.length && hi < arr.length) {
            if (arr[lo] > target) {
                break;
            }

            if (arr[lo] <= target && target <= arr[hi]) {
                System.out.println("steps: " + steps);
                System.out.println(BinarySearch(arr, lo, hi, target));
                return;
            } else {
                steps++;
                lo = hi + 1;
                hi = hi * 2;
            }
        }

        System.out.println(-1);
    }
}
